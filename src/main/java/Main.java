

import entidades.Livro;
import entidades.Autor;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class Main {
    public static void main(String[] args) {
        try {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

            Map<String, Object> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "org.postgresql.Driver");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
            settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/hibernate-schema");
            settings.put(Environment.USER, "deivid");
            settings.put(Environment.PASS, "deivid");
            settings.put(Environment.HBM2DDL_AUTO, "create-drop");
            settings.put(Environment.SHOW_SQL, true);
            registryBuilder.applySettings(settings);
            
            StandardServiceRegistry standardRegistry = registryBuilder.build();

            Metadata metadata = new MetadataSources(standardRegistry)
                    .addAnnotatedClass(Autor.class)
                    .addAnnotatedClass(Livro.class)
                    .getMetadataBuilder()
                    .build();

            SessionFactory sessionFactory = metadata
                    .getSessionFactoryBuilder()
                    .build();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
