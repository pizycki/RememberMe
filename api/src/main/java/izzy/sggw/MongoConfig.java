package izzy.sggw;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Paweł on 31.01.2016.
 */

@Configuration
@EnableMongoRepositories
@PropertySource("classpath:application.properties")
public class MongoConfig extends AbstractMongoConfiguration
{
    @Override
    protected String getDatabaseName() {
        return "izzyFilms";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }

    @Override
    protected String getMappingBasePackage() {
        return "izzy.sggw";
    }

}