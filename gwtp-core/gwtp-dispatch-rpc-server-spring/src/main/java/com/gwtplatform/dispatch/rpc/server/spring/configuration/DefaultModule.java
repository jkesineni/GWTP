/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.dispatch.rpc.server.spring.configuration;

import org.springframework.context.annotation.Bean;

import com.gwtplatform.dispatch.rpc.server.AbstractHttpSessionSecurityCookieFilter;
import com.gwtplatform.dispatch.rpc.server.RequestProvider;
import com.gwtplatform.dispatch.rpc.server.spring.HttpSessionSecurityCookieFilter;
import com.gwtplatform.dispatch.rpc.server.spring.request.DefaultRequestProvider;

/**
 * @author Peter Simun
 */
public class DefaultModule {

    private/* @Value("cookie") */ String securityCookieName;

    @Bean
    String getSecurityCookieName() {
        return securityCookieName;
    }

    @Bean
    AbstractHttpSessionSecurityCookieFilter getCookieFilter() {
        return new HttpSessionSecurityCookieFilter(getSecurityCookieName());
    }

    @Bean
    RequestProvider getRequestProvider() {
        return new DefaultRequestProvider();
    }
}