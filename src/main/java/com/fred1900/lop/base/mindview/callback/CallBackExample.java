package com.fred1900.lop.base.mindview.callback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import com.fred1900.lop.base.mindview.callback.base.PayNotification;
import com.fred1900.lop.base.mindview.callback.base.Product;
import com.fred1900.lop.base.mindview.callback.base.ProductPayResult;

public class CallBackExample {

	public static void main(String[] args) {
		GirlFriend gf = new GirlFriend(new BoyFriend());
		gf.goShop();

	}

	/**
	 * 女朋友实例
	 * 
	 * @author Fred
	 * @since 2017年4月15日
	 *
	 */
	public static class GirlFriend implements PayNotification {

		private BoyFriend bf;

		GirlFriend(BoyFriend bf) {
			this.bf = bf;
		}

		/**
		 * 购物
		 */
		private void goShop() {
			System.out.println("小爱，帮我付款，么么哒、、、");
			Product product = new Product();
			product.setId("11");
			product.setProductName("LV");
			payForMe(this, bf, product);
		}

		private void payForMe(final GirlFriend gf, final BoyFriend bf, final Product product) {
			ExecutorService executor = Executors.newSingleThreadExecutor();
			FutureTask<ProductPayResult> future = new FutureTask<ProductPayResult>(new Callable<ProductPayResult>() {

				public ProductPayResult call() throws Exception {
					bf.pay(product, gf);
					return null;
				}
			});
			executor.execute(future);
			try {
				ProductPayResult result = future.get(6000, TimeUnit.MILLISECONDS);
				System.out.println("付款结果" + result);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
				System.out.println("付款超时");
			} finally {
				System.out.println("取消付款");
				future.cancel(true);
				executor.shutdown();
			}
		}

		public void payNotify(ProductPayResult result) {
			if (ProductPayResult.RESP_CODE_SUCCESS.equals(result.getRespCode())) {
				System.out.println("小爱，么么哒、、、");
			} else {
				System.out.println("我们分手吧");
			}
		}

	}

	/**
	 * 男朋友实例
	 * 
	 * @author Fred
	 * @since 2017年4月15日
	 *
	 */
	public static class BoyFriend {

		private ProductPayResult pay(final Product product, final GirlFriend gf) throws Exception {
			ProductPayResult result = new ProductPayResult();
			try {
				Thread.sleep(5000l);
				System.out.println("付款成功，商品为" + product.getProductName());
				result.setRespCode(ProductPayResult.RESP_CODE_SUCCESS);
				result.setProductName(product.getProductName());
				result.setRespMsg("付款成功");
				gf.payNotify(result);
			} catch (InterruptedException e) {
				System.out.println("付款失败，商品为" + product.getProductName());
				result.setRespCode(ProductPayResult.RESP_CODE_FAIL_BUSY);
				result.setProductName(product.getProductName());
				result.setRespMsg("付款失败，网络问题");
				gf.payNotify(result);
			}
			return result;
		}
	}

}
