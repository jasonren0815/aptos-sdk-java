import com.aptos.request.v1.model.CoinStore;
import com.aptos.request.v1.model.Resource;
import com.aptos.request.v1.model.Struct;
import com.aptos.utils.AptosClient2;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

public class AptosClientTest {

    final String ledgerVersion = "29473448";

    final String host = "https://fullnode.devnet.aptoslabs.com";

    final String account1 = "0xc73b774dd8ea3ce870a29f20e9f37bc9631198bcf21dc294cc72fea27f212a10";

    AptosClient2 aptosClient;

    @Before
    public void init() {
        aptosClient = new AptosClient2(this.host);
    }

//    @Test
//    public void testResponseBlocksByVersion() {
//        RequestBlocksByVersionQuery requestBlocksByVersionQuery = RequestBlocksByVersionQuery.builder()
//                .withTransactions(true)
//                .build();
//
//        RequestBlocksByVersion requestBlocksByVersion = RequestBlocksByVersion.builder()
//                .ledgerVersion(this.ledgerVersion)
//                .query(requestBlocksByVersionQuery)
//                .build();
//
//        ResponseBlocksByVersion responseBlocksByVersion = aptosClient.call(requestBlocksByVersion, ResponseBlocksByVersion.class);
//        println(responseBlocksByVersion);
//    }

    @Test
    public void requestNode() {
        println(aptosClient.requestNode());
    }

    @Test
    public void requestEstimateGasPrice() {
        println(aptosClient.requestGasEstimate());
    }

    @Test
    public void requestAccountResources() {
        printlnList(aptosClient.requestAccountResources(this.account1));
    }

    @Test
    public void requestAccountResource() {
        println(aptosClient.requestAccountResource(this.account1, Struct.Account()));
        println(aptosClient.requestAccountResource(this.account1, CoinStore.coinStore(Struct.APT())));
    }

    @Test
    public void testRequestTransactionByHash() {
        println(aptosClient.requestTransactionByHash("0x363941d55528b648d979621f292956eb004f5cb7a9eb5ee1ad55df796ed5a0be"));
    }

//    @Test
//    public void testResponseToken() {
////        println(aptosClient.requestToken(this.account1, Token.APT()));
//    }


    void println(Serializable serializable) {
        System.out.println("--------------------" + serializable.getClass().getSimpleName());
        System.out.println(serializable);
        System.out.println("----------------------------------------");
    }

    @SuppressWarnings(value = {"rawtypes"})
    void printlnList(List serializable) {
        System.out.println("--------------------" + serializable.getClass().getSimpleName());
        System.out.println(serializable);
        System.out.println("----------------------------------------");
    }

}