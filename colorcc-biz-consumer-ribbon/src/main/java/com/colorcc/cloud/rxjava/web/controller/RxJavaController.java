/**
 * 
 */
package com.colorcc.cloud.rxjava.web.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cloud.netflix.rx.RxResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import rx.Observable;
import rx.Single;
import rx.functions.Func1;

/**
 * @author Duoduo (tianjieqin@126.com)
 * @date 2016年12月15日-下午11:04:33
 *
 */

@RestController
@RequestMapping("/rxjava")
public class RxJavaController {

	@RequestMapping(method = RequestMethod.GET, value = "/single")
	public Single<String> single() {
		return Single.just("single value");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/singleWithResponse")
	public ResponseEntity<Single<String>> singleWithResponse() {
		return new ResponseEntity<>(Single.just("single value"), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/singleCreatedWithResponse")
	public Single<ResponseEntity<String>> singleOuterWithResponse() {
		return Single.just(new ResponseEntity<>("single value", HttpStatus.CREATED));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/throw")
	public Single<Object> error() {
		return Single.error(new RuntimeException("Unexpected"));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/single2")
	public Single<String> single2() {
	    return Observable.just("single value").toSingle();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/multiple")
	public Single<List<String>> multiple() {
	    return Observable.just("multiple", "values").toList().toSingle();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/responseWithObservable")
	public ResponseEntity<Single<String>> responseWithObservable() {

	    Observable<String> observable = Observable.just("single value");
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	    return new ResponseEntity<>(observable.toSingle(), headers, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/timeout")
	public Observable<String> timeout() {
	    return Observable.timer(1, TimeUnit.MINUTES).map(new Func1<Long, String>() {
	        @Override
	        public String call(Long aLong) {
	            return "single value";
	        }
	    });
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sse")
	public SseEmitter single3() {
		return RxResponse.sse(Observable.just("single value"));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/messages")
	public SseEmitter messages() {
		return RxResponse.sse(Observable.just("message 1", "message 2", "message 3"));
	}

	@RequestMapping(method = RequestMethod.GET, value = "/events")
	public SseEmitter event() {
		return RxResponse.sse(MediaType.APPLICATION_JSON_UTF8,
				Observable.just("Spring io2016, 5, 19", "SpringOnePlatform 2016, 8, 1"));
	}

}
