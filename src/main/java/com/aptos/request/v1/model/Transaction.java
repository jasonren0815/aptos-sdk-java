package com.aptos.request.v1.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author liqiang
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {

    public static final String USER_TRANSACTION = "user_transaction";

    @JSONField(name = "version")
    String version;

    @JSONField(name = "hash")
    String hash;

    @JSONField(name = "state_change_hash")
    String stateChangeHash;

    @JSONField(name = "event_root_hash")
    String eventRootHash;

    @JSONField(name = "state_checkpoint_hash")
    String stateCheckpointHash;

    @JSONField(name = "gas_used")
    String gasUsed;

    @JSONField(name = "success")
    boolean success;

    @JSONField(name = "vm_status")
    String vmStatus;

    @JSONField(name = "accumulator_root_hash")
    String accumulatorRootHash;

    @JSONField(name = "sender")
    String sender;

    @JSONField(name = "sequence_number")
    String sequenceNumber;

    @JSONField(name = "max_gas_amount")
    String maxGasAmount;

    @JSONField(name = "gas_unit_price")
    String gasUnitPrice;

    @JSONField(name = "expiration_timestamp_secs")
    String expirationTimestampSecs;

    @JSONField(name = "signature")
    Signature signature;

    @JSONField(name = "events")
    List<Event<Map>> events;

    @JSONField(name = "proposer")
    String proposer;

    @JSONField(name = "timestamp")
    String timestamp;

    @JSONField(name = "type")
    String type;

    public String getTimestampMillisecond() {
        return String.valueOf(Long.parseLong(this.timestamp) / 1000L);
    }

}