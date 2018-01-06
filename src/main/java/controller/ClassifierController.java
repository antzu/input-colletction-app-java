//package controller;
//
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ClassifierController {
//
//
//}
//
//        resp.setContentType("application/json");
//
//                ClassifierInfo classifierInfo = new ClassifierInfo();
//                List<String> customerTypes = new ArrayList<>();
//        List<String> phoneTypes = new ArrayList<>();
//
//        phoneTypes.addAll(Arrays.asList("phone_type.fixed", "phone_type.mobile"));
//        customerTypes.addAll(Arrays.asList("customer_type.private", "customer_type.corporate"));
//
//        classifierInfo.setCustomerTypes(customerTypes);
//        classifierInfo.setPhoneTypes(phoneTypes);
//
//        new ObjectMapper().writeValue(resp.getOutputStream(), classifierInfo);