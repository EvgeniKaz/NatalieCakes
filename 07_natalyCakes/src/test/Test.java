package test;

import dao.ProdactDao;
import dao.UserDao;
import enums.ProductType;
import javaBeans.Product;
import javaBeans.User;

public class Test {
	//------------------DROP CREATE ALL TABLES AND FILL CATEGORY TABLE---------------------
	public void testAll() throws Exception {
	TableCreator tableCreator=new TableCreator();
	
	tableCreator.dropDB(TableCreator.tableNameProducts);
	tableCreator.dropDB(TableCreator.tableNameUsers);
	
	tableCreator.buildDB(TableCreator.productTableCreateCommand);
	tableCreator.buildDB(TableCreator.userTableCreateCommand);
	
	ProdactDao prodactDao = new ProdactDao();
	UserDao userDao = new UserDao();
	User user = new User("nataly", "password", "0542368320");
	user.setId(userDao.addUser(user));
	System.out.println(user.getId());
	user.setPassword("another");
	user.setUserName("another");
	user.setTelephone("another");
	userDao.updateUser(user);
	Product cake = new Product(ProductType.THEME_CAKES, "Choko cake", 250.5, "Our best choko cake with oranges", "image");
	Product cake2 = new Product(ProductType.PARTY_SETS, "Party cake", -250.5, "Our best party cake with oranges", "image");
	cake.setId(prodactDao.addProduct(cake));
	cake.setName("cream cake");
	cake.setDescription("gentle and creamy");
	cake.setImage("new image");
	cake.setPrice(123.6);
	prodactDao.updateProduct(cake);
	prodactDao.addProduct(cake2);
	System.out.println(userDao.getOneUser(user.getId()));
	System.out.println(prodactDao.getOneProduct(cake.getId()));
	System.out.println(prodactDao.getAllProducts());
	prodactDao.deleteProduct(cake.getId());
	userDao.deleteUser(user.getId());
}
}