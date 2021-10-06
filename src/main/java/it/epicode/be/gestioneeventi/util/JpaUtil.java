package it.epicode.be.gestioneeventi.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final EntityManagerFactory entityManagerFactory;
	/*
	 * istanzia una EntityManagerFactory associata alla persistenza unit definita
	 * nel persistence.xml istanzia una EntityManagerFactory associata alla
	 * persistenza unit definita nel persistence.xml 
	 * <persistence-unit name="GestioneEvento"> 
	 * <properties> 
	 * <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver" />
	 * <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/epicode-be" /> 
	 * <property name="javax.persistence.jdbc.user" value="epicode" />
	 * <property name="javax.persistence.jdbc.password" value="epicode" /> 
	 * <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect" />
	 * <property name="hibernate.default_schema" value="gestioneeventi" /> 3
	 * <property name="hibernate.hbm2ddl.auto" value="create" /> 
	 * </properties>
	 * </persistence-unit>
	 */

	static {
		try {
	// crea una istanza di EntityManager con associato il proprio Peristence Context		
			entityManagerFactory = Persistence.createEntityManagerFactory("GestioneEvento");
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
