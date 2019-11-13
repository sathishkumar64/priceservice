package com.angadi.price.api.grpc;

import java.math.BigDecimal;

import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import com.angadi.price.api.model.PriceData;
import com.angadi.price.api.repositories.PriceDao;

import lombok.extern.slf4j.Slf4j;

@GRpcService
@Slf4j
public class PriceServiceImpl extends PriceServiceGrpc.PriceServiceImplBase {
	
	@Autowired
	private PriceDao priceDao;

	@Override
	public void createPrice(com.angadi.price.api.grpc.PriceRequest request,
			io.grpc.stub.StreamObserver<com.angadi.price.api.grpc.PriceResponse> responseObserver) {		
		log.info("Saving Price for Product.......");			
		priceDao.save(new PriceData(request.getVendorID(),request.getImageId(),new BigDecimal(request.getPrice())));		
		PriceResponse priceResponse = PriceResponse.newBuilder().setStatus("Price Updated").build();		
		log.info("server responded {}", priceResponse);
		responseObserver.onNext(priceResponse);
		responseObserver.onCompleted();
	}

	public void updatePrice(com.angadi.price.api.grpc.PriceUpdateRequest request,
			io.grpc.stub.StreamObserver<com.angadi.price.api.grpc.PriceResponse> responseObserver) {

	}

	/**
	 */
	public void deletePrice(com.angadi.price.api.grpc.PriceDeleteRequest request,
			io.grpc.stub.StreamObserver<com.angadi.price.api.grpc.PriceResponse> responseObserver) {

	}

}
