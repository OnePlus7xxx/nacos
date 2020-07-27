/*
 *  Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.alibaba.nacos.naming.consistency.persistent;

import com.alibaba.nacos.common.notify.Event;
import com.alibaba.nacos.naming.consistency.ApplyAction;
import com.alibaba.nacos.naming.pojo.Record;

/**
 * @author <a href="mailto:liaochuntao@live.com">liaochuntao</a>
 */
public class ValueChangeEvent extends Event {
    
    private final String key;
    
    private final Record value;
    
    private final ApplyAction action;
    
    public ValueChangeEvent(String key, Record value, ApplyAction action) {
        this.key = key;
        this.value = value;
        this.action = action;
    }
    
    public String getKey() {
        return key;
    }
    
    public Record getValue() {
        return value;
    }
    
    public ApplyAction getAction() {
        return action;
    }
    
    public static final class ValueChangeEventBuilder {
        
        private String key;
        
        private Record value;
        
        private ApplyAction action;
        
        private ValueChangeEventBuilder() {
        }
        
        public static ValueChangeEventBuilder aValueChangeEvent() {
            return new ValueChangeEventBuilder();
        }
        
        public ValueChangeEventBuilder key(String key) {
            this.key = key;
            return this;
        }
        
        public ValueChangeEventBuilder value(Record value) {
            this.value = value;
            return this;
        }
        
        public ValueChangeEventBuilder action(ApplyAction action) {
            this.action = action;
            return this;
        }
        
        public ValueChangeEvent build() {
            return new ValueChangeEvent(key, value, action);
        }
    }
}