package com.hos.liferay;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.hos.liferay.model.CustomerItems;
import com.hos.liferay.persistence.StoreProductServiceImpl;
import com.hos.liferay.service.SalesReceiptService;

public class InputThreeTest {
	private int INPUT_NUMBER = 3;
	
	@Test
	public void testInputItemcount() throws Exception {
		List<CustomerItems> custItems = null;
		StoreProductServiceImpl storeProductService = new StoreProductServiceImpl();
		custItems = storeProductService.fetchAllStoreItems(INPUT_NUMBER);
		assertEquals(custItems.size(), 4);
	}
	
	@Test
	public void testInputItemTotal() throws Exception {
		List<CustomerItems> custItems = null;
		StoreProductServiceImpl storeProductService = new StoreProductServiceImpl();
		custItems = storeProductService.fetchAllStoreItems(INPUT_NUMBER);
		SalesReceiptService receiptSvc = new SalesReceiptService(custItems);
		BigDecimal total = receiptSvc.getReceiptTotal();
		BigDecimal expectedTotal = new BigDecimal("74.68");
		assertTrue(total.equals(expectedTotal));
	}
	
	@Test
	public void testInputItemTaxTotal() throws Exception {
		List<CustomerItems> custItems = null;
		StoreProductServiceImpl storeProductService = new StoreProductServiceImpl();
		custItems = storeProductService.fetchAllStoreItems(INPUT_NUMBER);
		SalesReceiptService receiptSvc = new SalesReceiptService(custItems);
		BigDecimal total = receiptSvc.getTaxTotal();
		BigDecimal expectedTotal = new BigDecimal("6.70");
		assertTrue(total.equals(expectedTotal));
	}
}
