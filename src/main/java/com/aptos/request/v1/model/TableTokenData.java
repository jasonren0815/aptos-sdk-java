package com.aptos.request.v1.model;

import com.alibaba.fastjson2.annotation.JSONField;
import com.aptos.utils.Hex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liqiang
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableTokenData implements Serializable {

    @JSONField(name = "default_properties")
    DefaultProperties defaultProperties;

    @JSONField(name = "description")
    String description;

    @JSONField(name = "largest_property_version")
    String largestPropertyVersion;

    @JSONField(name = "maximum")
    String maximum;

    @JSONField(name = "mutability_config")
    MutabilityConfig mutabilityConfig;

    @JSONField(name = "name")
    String name;

    @JSONField(name = "royalty")
    Royalty royalty;

    @JSONField(name = "supply")
    String supply;

    @JSONField(name = "uri")
    String uri;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class DefaultProperties implements Serializable {

        @JSONField(name = "map")
        PropertyMap map;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class MutabilityConfig implements Serializable {

        @JSONField(name = "description")
        boolean description;

        @JSONField(name = "maximum")
        boolean maximum;

        @JSONField(name = "properties")
        boolean properties;

        @JSONField(name = "royalty")
        boolean royalty;

        @JSONField(name = "uri")
        boolean uri;

    }

    public void decode() {
        this.defaultProperties.map.data.forEach(data -> {
            data.key = Hex.decodeToString(data.key);
            data.value.type = Hex.decodeToString(data.value.type);
            data.value.value = Hex.decodeToString(data.value.value);
        });
        this.description = Hex.decodeToString(this.description);
        this.name = Hex.decodeToString(this.name);
        this.uri = Hex.decodeToString(this.uri);
    }

}