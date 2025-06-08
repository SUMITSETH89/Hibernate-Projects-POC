package com.sLsD.id.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("RandomIdGenerator::generateMethod Invoked");
		return (long)new Random().nextInt(10000);
	}

}
