package com.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.domain.Application;
import com.mobile.domain.CallingPlan;
import com.mobile.domain.Card;
import com.mobile.domain.Carrier;
import com.mobile.domain.Device;
import com.mobile.domain.Installment;
import com.mobile.domain.Products;
import com.mobile.domain.WiredGoods;
import com.mobile.repository.ApplicationRepository;
import com.mobile.repository.CallingPlanRepository;
import com.mobile.repository.CardRepository;
import com.mobile.repository.CarrierRepository;
import com.mobile.repository.DeviceRepository;
import com.mobile.repository.InstallmentRepository;
import com.mobile.repository.ProductsRepository;
import com.mobile.repository.WiredGoodsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	
	ApplicationRepository applicationRepository;
	CallingPlanRepository callingPlanRepository;
	CarrierRepository carrierRepository;
	DeviceRepository deviceRepository;
	ProductsRepository productsRepository; 
	InstallmentRepository installmentRepository;
	WiredGoodsRepository wiredGoodsRepository;
	CardRepository cardRepository;
	
	
	@Override
	public List<Application> applicationSelectAll() {
		
		return applicationRepository.findAll();
	}

	@Override
	public List<Application> applicationSelectByState(Integer state) {
		
		return applicationRepository.findByState(state);
	}

	@Override
	public List<Application> applicationSelectByMemberId(Long memberId) {
		return applicationRepository.findBymemberId(memberId);
	}

	@Override
	public Application applicationSelectById(Long applicationId) {
		return applicationRepository.findById(applicationId).orElse(null);
	}

	@Override
	public void applicationInsert(Application application) {
		applicationRepository.save(application);
	}

	@Override
	public void applicationUpdate(Application application) {
		Application a = applicationRepository.findById(application.getApplicationId()).orElse(null);
		
		if(a!=null) {
			if(application.getState()!=null) {
				a.setState(application.getState());
			}
		}
		
		applicationRepository.save(a);

	}

	@Override
	public List<CallingPlan> callingPlanSelectAll() {
		
		return callingPlanRepository.findAll();
	}

	@Override
	public List<CallingPlan> callingPlanSelectActivatedAll() {
		
		return callingPlanRepository.findActivatedAll();
	}

	@Override
	public List<CallingPlan> callingPlanSelectByCarrierId(Long carrierId) {
		return callingPlanRepository.findByCarrier(carrierId);
	}

	@Override
	public CallingPlan callingPlanSelectById(Long callingPlanId) {

		return callingPlanRepository.findById(callingPlanId).orElse(null);
	}

	@Override
	public void callingPlanInsert(CallingPlan callingPlan) {
		callingPlanRepository.save(callingPlan);

	}

	@Override
	public void callingPlanUpdate(CallingPlan callingPlan) {
		CallingPlan c = callingPlanRepository.findById(callingPlan.getCallingPlanId()).orElse(null);
	
		if(c!= null) {
			
			if(callingPlan.getBasicFee()!=null) {
				c.setBasicFee(callingPlan.getBasicFee());
			}
			
			if(callingPlan.getBondDiscount()!=null) {
				c.setBondDiscount(callingPlan.getBondDiscount());
			}
			
			
			if(callingPlan.getNetworkType()!=null) {
				c.setNetworkType(callingPlan.getNetworkType());
			}
			
			if(callingPlan.getPlanName()!=null) {
				c.setPlanName(callingPlan.getPlanName());
			}
			
			if(callingPlan.getState()!=null) {
				c.setState(callingPlan.getState());
			}
			
			if(callingPlan.getCarrier()!=null) {
				c.setCarrier(callingPlan.getCarrier());
			}
			
			callingPlanRepository.save(c);
		}
		

	}

	@Override
	public void callingPlanChangeState(Long callingPlanId) {
		
		CallingPlan callingPlan = callingPlanRepository.findById(callingPlanId).orElse(null);
		int state;
		
		if(callingPlan != null) {
			state = callingPlan.getState();
			
			if(state == 0) {
				callingPlan.setState(1);
			} else {
				callingPlan.setState(0);
			}
			callingPlanRepository.save(callingPlan);
		}

	}

	@Override
	public List<Carrier> carrierSelectAll() {
		return carrierRepository.findAll();
	}

	@Override
	public Carrier carrierSelectById(Long carrierId) {
		return carrierRepository.findById(carrierId).orElse(null);
	}

	@Override
	public void carrierInsert(Carrier carrier) {
		carrierRepository.save(carrier);

	}

	@Override
	public void carrierUpdate(Carrier carrier) {
		Carrier c = carrierRepository.findById(carrier.getCarrierId()).orElse(null);

		if(c!=null) {
			if(carrier.getCarrierName()!=null) {
				c.setCarrierName(carrier.getCarrierName());
			}
			
			carrierRepository.save(c);
		}

	}

	@Override
	public List<Device> deviceSelectAll() {
		
		return deviceRepository.findAll();
	}

	@Override
	public Device deviceSelectById(Long deviceId) {
		
		return deviceRepository.findById(deviceId).orElse(null);
	}

	@Override
	public void deviceInsert(Device device) {
		deviceRepository.save(device);

	}

	@Override
	public void deviceUpdate(Device device) {
		
		Device d = deviceRepository.findById(device.getDeviceId()).orElse(null);
		
		if(d!=null) {
			if(device.getDeviceName()!=null) {
				d.setDeviceName(device.getDeviceName());
			}
			
			if(device.getPrice()!=null) {
				d.setPrice(device.getPrice());
			}
			
			deviceRepository.save(d);
		}
		

	}

	@Override
	public void deviceChangeState(Long deviceId) {
		
		Device device = deviceRepository.findById(deviceId).orElse(null);
		int state;
		
		if(device != null) {
			state = device.getState();
			
			if(state == 0) {
				device.setState(1);
			} else {
				device.setState(0);
			}
			deviceRepository.save(device);
		}

	}

	@Override
	public List<Products> productsSelectAll() {
		
		return productsRepository.findAll();

	}

	@Override
	public Products productsSelectById(Long id) {
		
		return productsRepository.findById(id).orElse(null);

	}

	@Override
	public List<Products> productsSelectActivatedAll() {
		
		return productsRepository.findActivatedAll();

	}

	@Override
	public List<Products> productsSearching(Long carrierId, Integer activationType, Long deviceId, Integer subcondition,
			Long officeId) {
		return null;

	}

	@Override
	public void productInsert(Products product) {
		productsRepository.save(product);

	}

	@Override
	public void productUpdate(Products product) {
		Products p = productsRepository.findById(product.getProductsId()).orElse(null);
		
		if(p!=null) {
			if(product.getActivationType()!=null) {
				p.setActivationType(product.getActivationType());
			}
			
			if(product.getCallingPlan()!=null) {
				p.setCallingPlan(product.getCallingPlan());
			}
			
			if(product.getCarrier()!=null) {
				p.setCarrier(product.getCarrier());
			}
			
			if(product.getDevice()!=null) {
				p.setDevice(product.getDevice());
			}
			
			if(product.getIsReccomendationProducts()!=null) {
				p.setIsReccomendationProducts(product.getIsReccomendationProducts());
			}
			
			if(product.getMainSupportFund()!=null) {
				p.setMainSupportFund(product.getMainSupportFund());
			}
			
			if(product.getMarketSupportFund()!=null) {
				p.setMarketSupportFund(product.getMarketSupportFund());
			}
			
			if(product.getOffice()!=null) {
				p.setOffice(product.getOffice());
			}
			
			if(product.getState()!=null) {
				p.setState(product.getState());
			}
		}

	}

	@Override
	public void productChangeState(Long productsId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Installment> installmentSelectAll() {
		
		return installmentRepository.findAll();
	}

	@Override
	public Installment installmentSelectById(Long installmentId) {
		
		return installmentRepository.findById(installmentId).orElse(null);
	}

	@Override
	public List<WiredGoods> wiredGoodsSelectAll() {
		return wiredGoodsRepository.findAll();
	}

	@Override
	public List<WiredGoods> wiredGoodsSelectActivatedAll() {

		return null;
	}

	@Override
	public WiredGoods wiredGoodsSelectById(Long wiredGoodsId) {
		
		return wiredGoodsRepository.findById(wiredGoodsId).orElse(null);
	}

	@Override
	public void wiredGoodsInsert(WiredGoods wiredGoods) {
		wiredGoodsRepository.save(wiredGoods);
		
	}

	@Override
	public void wiredGoodsUpdate(WiredGoods wiredGoods) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wiredGoodsDelete(Long wiredGoodsId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> cardSelectAll() {
		
		return cardRepository.findAll();
	}

	@Override
	public List<Card> cardSelectActivatedAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card cardSelectById(Long cardId) {
		
		return cardRepository.findById(cardId).orElse(null);
	}

	@Override
	public void cardInsert(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardUpdate(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cardDelete(Long cardId) {
		// TODO Auto-generated method stub
		
	}

}
