package petstoreAPI.api.test;

import org.testng.annotations.Test;

import io.restassured.response.Response;


import org.testng.Assert;


import petstoreAPI.api.Endpoints.UserEndpoints;
import petstoreAPI.api.payload.User;
import petstoreAPI.api.ultilities.DataProviders;


public class APItests {

	
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class )
	public void testPostuserWithDataProvider(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=UserEndpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
			
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByNameWithDataProvider(String userName)
	{
			Response response=UserEndpoints.deleteUser(userName);
			
			Assert.assertEquals(response.getStatusCode(),200);	
	
	}
	
	
	
}
