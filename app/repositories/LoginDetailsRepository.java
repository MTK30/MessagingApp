//package repositories;
//
//import models.LoginDetails;
//
//import javax.inject.Singleton;
//
//@Singleton
//public class LoginDetailsRepository extends EbeanRepository<LoginDetails,Long> {
//
//    public LoginDetailsRepository() { super(LoginDetails.class);}
//
//    public LoginDetails getLoggedInUser(String userName,String pwd) {
//        return getCareerCarrierReadctx().find(LoginDetails.class)
//                .where()
//                .eq("user_name",userName)
//                .eq("pwd",pwd)
//                .findOne();
//    }
//
//}
