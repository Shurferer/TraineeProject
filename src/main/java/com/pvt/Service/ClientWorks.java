package com.pvt.Service;


import com.pvt.model.Request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientWorks {
        
        @Autowired
        private  ServiceRequestDAO requestDao;
         
public Request findOfferInDataBaseUsingClientRequest (Request req){
            List<Request> requestList = requestDao.getRequestsByType(req.getType());
		return findBestOffer (req, requestList);
	}
	public  Map<Request, Request> distributeRequests (){
		Map<Request,Request> resultPairs = new HashMap <Request,Request> () ;
		List<Request> EmployeeRequestList = requestDao.getRequestsByType(2);
		List<Request> WorkerRequestList = requestDao.getRequestsByType(1);
		for (Request reqWork:WorkerRequestList){
			if (!(findBestOffer(reqWork, EmployeeRequestList)==null)){
				resultPairs.put(reqWork, findBestOffer(reqWork, EmployeeRequestList));
			}
		}
		return resultPairs;
	}
	public Request findBestOffer (Request req, List<Request> listRequest){
		Request resultRequest = null;
		double tempPayment = req.getPayment();
		for (Request reqq :listRequest){
			double delta = (tempPayment-reqq.getPayment())/tempPayment;
			if ((Math.abs(delta*100))<25) {
				resultRequest = reqq;
				break;			
			}
		}
		return resultRequest;
	}
}
