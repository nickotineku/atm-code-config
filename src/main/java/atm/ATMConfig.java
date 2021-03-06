package atm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMConfig {

    @Bean
    public DataSource dataSource(){
        return new DataSourceDB();
        // change DataSourceDB to DataSourceFile if want to load customer from file
    }

    @Bean
    public Bank bank(){
        return new Bank("My Bank",dataSource());
    }

    @Bean
    public ATM atm(){
        return new ATM(bank());
    }

    @Bean
    public AtmUI atmUI(){
        return new AtmUI(atm());
    }
}
//Comment test git