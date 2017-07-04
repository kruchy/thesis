package pl.edu.agh.kis.kruchy.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import pl.edu.agh.kis.kruchy.configuration.HibernateTestConfiguration;

@ContextConfiguration(classes = { HibernateTestConfiguration.class })
public class HibernateRepositoryTest extends AbstractTransactionalTestNGSpringContextTests
{
    @Autowired
    DataSource dataSource;
    @BeforeMethod
    public void setUp() throws Exception {
        IDatabaseConnection dbConn = new DatabaseDataSourceConnection(
                dataSource);
        DatabaseOperation.CLEAN_INSERT.execute(dbConn, getDataSet());
    }

    protected IDataSet getDataSet() throws Exception
    {
        return null;
    }
}
