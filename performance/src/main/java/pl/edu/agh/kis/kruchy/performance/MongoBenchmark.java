/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package pl.edu.agh.kis.kruchy.performance;

import org.apache.commons.text.RandomStringGenerator;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.edu.agh.kis.kruchy.common.model.User;
import pl.edu.agh.kis.kruchy.common.repository.UserRepository;
import pl.edu.agh.kis.kruchy.mongo.configuration.MongoConfiguration;
import pl.edu.agh.kis.kruchy.mongo.repository.DefaultMongoRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.util.Optional.ofNullable;
import static pl.edu.agh.kis.kruchy.common.model.builder.UserBuilder.anUser;

@State(value = Scope.Thread)
public class MongoBenchmark {

    private UserRepository mongoRepository;

    private User user;
    private RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();

    public MongoBenchmark() {
        SpringApplication springApplication = new SpringApplication(MongoConfiguration.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setLogStartupInfo(false);
        ConfigurableApplicationContext context = springApplication.run("");
        mongoRepository = context.getBean(DefaultMongoRepository.class);

    }

    @Setup(value = Level.Invocation)
    public void setUp() {
        for (int i = 0; i < 1000; i++) {
            user = randomUser();
            User save = mongoRepository.save(user);
            ofNullable(save).ifPresent(user1 -> {
            });
        }


    }

    @TearDown(value = Level.Invocation)
    @Warmup
    public void tearDown() {
        Object o = mongoRepository.deleteAll();
        ofNullable(o).ifPresent(object -> {
        });
    }

    @Benchmark
    public void measureSavingUser(Blackhole blackhole) {
        User user = randomUser();
        User saved = mongoRepository.save(user);
        blackhole.consume(saved);
    }


    @Benchmark
    public void measureDeletingAllUsers(Blackhole blackhole) {
        Object dummy = mongoRepository.deleteAll();
        blackhole.consume(dummy);
    }


    @Benchmark
    public void measureUpdatingUser(Blackhole blackhole) {
        user.setName("NEWNAME");
        user.setAge(15);
        User saved = mongoRepository.save(user);
        blackhole.consume(saved);
    }

    @Benchmark
    public void measureFindingByPhoneNumber(Blackhole blackhole) {
        Optional<User> found = mongoRepository.findByPhoneNumber(user.getPhoneNumber());
        blackhole.consume(found);
    }


    @Benchmark
    public void measureDeleteUser(Blackhole blackhole) {
        User dummy = mongoRepository.delete(user);
        blackhole.consume(dummy);
    }

    @Benchmark
    public void measureDeleteUserById(Blackhole blackhole) {
        String dummy = mongoRepository.delete(user.getId());
        blackhole.consume(dummy);
    }

    @Benchmark
    public void measureFindAll(Blackhole blackhole) {
        List<User> all = mongoRepository.findAll();
        blackhole.consume(all);
    }

    @Benchmark
    public void measureFindById(Blackhole blackhole) {
        Optional<User> foundById = mongoRepository.findById(user.getId());
        blackhole.consume(foundById);
    }

    @Benchmark
    public void measureFindByPhoneNumber(Blackhole blackhole) {
        Optional<User> foundByPhoneNumber = mongoRepository.findByPhoneNumber(user.getPhoneNumber());
        blackhole.consume(foundByPhoneNumber);
    }

    @Benchmark
    public void measureFindByName(Blackhole blackhole) {
        List<User> foundByName = mongoRepository.findAllByName(user.getName());
        blackhole.consume(foundByName);
    }

    @Benchmark
    public void measureFindBySurname(Blackhole blackhole) {
        List<User> foundByName = mongoRepository.findAllBySurname(user.getSurname());
        blackhole.consume(foundByName);
    }

    private User randomUser() {
        Random random = new Random();

        return anUser().withName(randomStringGenerator.generate(7))
                .withSurname(randomStringGenerator.generate(7))
                .withAddress(randomStringGenerator.generate(10), random.nextInt(90))
                .withPhoneNumber(randomStringGenerator.generate(9))
                .withAge(random.nextInt(70) + 10);
    }


    public static void main(String[] args) throws RunnerException, IOException {
        File output = new File("./mongoBenchmark");
        if (!output.exists()) {
            output.createNewFile();
        }

        Options opt = new OptionsBuilder()
                .include(MongoBenchmark.class.getSimpleName())
                .mode(Mode.All)
                .timeUnit(TimeUnit.MILLISECONDS)
                .output(output.getName())
                .build();
        new Runner(opt).run();
    }
}
