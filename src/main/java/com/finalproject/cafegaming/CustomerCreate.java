package com.finalproject.cafegaming;

import com.intuit.ipp.core.Context;
import com.intuit.ipp.core.ServiceType;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.security.OAuth2Authorizer;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.util.Config;
import com.intuit.ipp.util.Logger;
import org.apache.commons.lang.RandomStringUtils;


public class CustomerCreate {
    private static final org.slf4j.Logger LOG = Logger.getLogger();

    public static void main(String[] args) throws FMSException {
        OAuth2Authorizer oauth = new OAuth2Authorizer("eyJlbmMiOiJBMTI4Q0JDLUhTMjU2IiwiYWxnIjoiZGlyIn0..DHys6G7HMM7xSXSUtWcD5A.1waARuTBL3wzx4jIlpbbCweprKV9WH6hYYOQPDCmUYqop5RtMTTdVdDu9BX7o5VVnekK141UrABv11MFglECPG3NXZ5haoKu-82oVzqGBaJXuifS3cbwVexSe4hJbfz-9HqwMYj1ELWawZCSDHpJ0d5CzmtUPFiDWWr4XgO-CE7CfMTToo4ciqM8ocF_g4QY-d0pQWnLKhqDzfzpq2HNzpjoGyllZrMGaM5Qdk-95m7o9HoNd6iV7QJCMGlbGq6cVxHCWJZg0Nxa1Jig-RTGYypslBlXxQ_CSyM6Au58Ye5yEmrUuf8dwliK_Ag_1VpLDHUfTfOfanKe4MjLsznVzVFcJHXYDMDVgd4U0st3_jjHOlGnVdiOGUruJ5WwwyBtwI9IvqB3rmlg-eEOPi-X30WrCyz5nWyrbgq8OruhsvCkNLR0OmcHRDkvC74eTXF19KhepEofOFeGhVtD0_2Exx1m844WmgjbFIQqDoS8QkjQg27edttCV4yStQ9CI7c3ZbIxC-9hPijWqw_gTLQPmaeibo1744Kim8gydaqIgQ2JwJ82RlAKNDwwZ6EZx_tcRg76E-2M5Tvbi2yXsO3mbmc_f6_37awAgd9o44dt9RgDmyZgf4t0e2LbRWtF0i8jievgLUY71NdBudZpVWq-C9Lku33V9Z9Zl4FEeSwl_x8SbgVD53UzG2vi88dteyqxEoS3YszloX16LpOpYsR5gd0DAtSfOrIeRcZYI9KpUPh5x_-u3b5fpoHAZRw_WzMMJFjxyAnfeKBj2mvxKRhk2omiRr-0-1PfccRxt9qytwk8RJIVBEHaS_UXkZAmCk2RzcrKclsEXClRYeL3rqy0yII0IIIggplmv81w4C_BrnGpAhjlSsmyrdfZwhSej0Ys.G7fqxgsdpqUmxxiO9wZXkw");
        //create context
        Context context = new Context(oauth, ServiceType.QBO, "4620816365153243980");
        Config.setProperty(Config.BASE_URL_QBO,"https://sandbox-quickbooks.api.intuit.com/v3/company");
        DataService service = new DataService(context);

        Customer customer = new Customer();
        // Mandatory Fields
        customer.setDisplayName(RandomStringUtils.randomAlphanumeric(6));
        Customer savedCustomer = service.add(customer);
        LOG.info("Customer with mandatory fields created: " + savedCustomer.getId() + " ::customer name: " + savedCustomer.getDisplayName());
    }

}
