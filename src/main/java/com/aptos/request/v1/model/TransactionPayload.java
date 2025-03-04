package com.aptos.request.v1.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author liqiang
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings({"rawtypes"})
public class TransactionPayload implements Serializable {

    /**
     * TransactionPayload transactionPayload = TransactionPayload.builder()
     * .function("0x2b490841c230a31fe012f3b2a3f3d146316be073e599eb7d7e5074838073ef14::message::set_message")
     * .arguments(List.of("hello"))
     * .build();
     */

    public static final String ENTRY_FUNCTION_PAYLOAD = "entry_function_payload";

    @JSONField(name = "type")
    String type;

    @JSONField(name = "function")
    String function;

    @JSONField(name = "arguments")
    List arguments;

    @JSONField(name = "type_arguments")
    List typeArguments;

}