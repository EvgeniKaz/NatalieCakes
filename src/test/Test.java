package test;

import dao.ProdactDao;
import enums.ProductType;
import javaBeans.Product;

public class Test {
	//------------------DROP CREATE ALL TABLES AND FILL CATEGORY TABLE---------------------
	public void testAll() throws Exception {
	TableCreator tableCreator=new TableCreator();
	
	tableCreator.dropDB(TableCreator.tableNameProducts);
	tableCreator.dropDB(TableCreator.tableNameUsers);
	
	tableCreator.buildDB(TableCreator.productTableCreateCommand);
	tableCreator.buildDB(TableCreator.userTableCreateCommand);
	
	ProdactDao prodactDao = new ProdactDao();
	Product cake = new Product(ProductType.THEME_CAKES, "Choko cake", 250.5, "Our best choko cake with oranges", "image");
	cake.setId(prodactDao.addProduct(cake));
	cake.setName("cream cake");
	cake.setDescription("gentle and creamy");
	cake.setImage("new image");
	cake.setPrice(123.6);
	prodactDao.updateProduct(cake);
}
}