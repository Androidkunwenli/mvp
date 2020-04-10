package com.zyk.baselibrary.http.convert;

import com.zyk.baselibrary.http.exception.ApiException;
import com.zyk.baselibrary.http.BaseResponse;

import io.reactivex.functions.Function;

/**
 * @Author: KK
 * @时间: 2020/4/10 9:20
 * @描述: 解析BaseResponse
 */
public class ResponseConvert<E> implements Function<BaseResponse<E>, E> {
    @Override
    public E apply(BaseResponse<E> baseResponse) {
        if (baseResponse.getCode() != 200) {
            // 手动抛出异常
            throw new ApiException(baseResponse.getCode(), baseResponse.getMessage());
        }
        return baseResponse.getResult();
    }
}
