/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.api;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 *
 * @author eduardo
 */
public interface ApiBuilder {
    static <T> T buildAPI(Class<T> api, String url) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(api, url);
    }
    
}
