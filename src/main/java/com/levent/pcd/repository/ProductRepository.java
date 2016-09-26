package com.levent.pcd.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.levent.pcd.model.Product;

/*
 * Repository Layer is responsible for retrievel of data
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
	  @Query("{ 'productCode' : ?0 }")
	  Product findByProductCode(String productCode);
	  
	  /*
	   * Same functionality with the query below
	   * 
	   * db.products.find({ categories: { '$in':['children'] } })
	   * 
	   */
	  @Query("{ 'categories': { $elemMatch: { $eq: ?0 } } }")
	  List<Product> findProductsByCategory(String categoryName);
	  
	  /*
	   * db.products.find( { 'productName': /mens/i } );
	   * @Query("{ 'productName': /?0/i }")
	   * 
	   */
	  @Query("{ 'productName':{$regex:?0,$options:'i'} }") 
	  List<Product> findProductsByProductNameRegex(String searchString);
	  
}
