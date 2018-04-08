package com.Ilvcode.service.impl;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.Ilvcode.Application;
import com.Ilvcode.WebSocketConfig;


@ContextConfiguration(classes = Application.class)
@RunWith(SpringRunner.class)
//@SpringBootTest(properties = {"port=8080","useLocalHost=false"})
public class UserPoolAccessServiceTest {
	@Autowired
	UserPoolAccessService userPoolAccessService;
	Set<String> userPool;
	@Before
	public void setUp() throws Exception {
		userPool = userPoolAccessService.getInstance().getList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_addUser_AddOneUser() {
		userPool.clear();
		userPoolAccessService.addUser("John");
		assertTrue("testAddOneUser",userPool.contains("John"));
	}
	@Test
	public void test_addUser_AddTwoUserGetSizeTwo() {
		userPool.clear();
		userPoolAccessService.addUser("John");
		userPoolAccessService.addUser("Sean");
		assertEquals("testAddTwoUserGetSizeTwo",2,userPool.size());
	}
	@Test
	public void test_isFull_Add9UsersThenIsFullReturnFalse() {
		userPool.clear();
		userPoolAccessService.addUser("John");
		System.out.println("size:" + userPool.size());
		userPoolAccessService.addUser("Sean");
		System.out.println("size:" + userPool.size());
		userPoolAccessService.addUser("John1");
		System.out.println("size:" + userPool.size());
		userPoolAccessService.addUser("Sean2");
		System.out.println("size:" + userPool.size());
		userPoolAccessService.addUser("John3");
		System.out.println("size:" + userPool.size());
		userPoolAccessService.addUser("Sean4");
		userPoolAccessService.addUser("John5");
		userPoolAccessService.addUser("Sean6");
		userPoolAccessService.addUser("Sean7");
		userPoolAccessService.updateIsFull();
		assertFalse("testAdd9UsersThenIsFullReturnFalse",userPoolAccessService.isFull());
	}
	@Test
	public void test_isFull_Add10UsersThenIsFullReturnTrue() {
		userPool.clear();
		userPoolAccessService.addUser("John");
		userPoolAccessService.addUser("Sean");
		userPoolAccessService.addUser("John1");
		userPoolAccessService.addUser("Sean2");
		userPoolAccessService.addUser("John3");
		userPoolAccessService.addUser("Sean4");
		userPoolAccessService.addUser("John5");
		userPoolAccessService.addUser("Sean6");
		userPoolAccessService.addUser("Sean7");
		userPoolAccessService.addUser("Sean8");
		userPoolAccessService.updateIsFull();
		
		assertTrue("testAdd10UsersThenIsFullReturnTrue",userPoolAccessService.isFull());
	}

}
