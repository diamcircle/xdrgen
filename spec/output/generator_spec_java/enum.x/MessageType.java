// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package MyXDR;


import java.io.IOException;


// === xdr source ============================================================

//  enum MessageType
//  {
//      ERROR_MSG,    
//      HELLO,
//      DONT_HAVE,
//  
//      GET_PEERS,   // gets a list of peers this guy knows about        
//      PEERS,
//  
//      GET_TX_SET,  // gets a particular txset by hash        
//      TX_SET,    
//  
//      GET_VALIDATIONS, // gets validations for a given ledger hash        
//      VALIDATIONS,    
//  
//      TRANSACTION, //pass on a tx you have heard about        
//      JSON_TRANSACTION,
//  
//      // FBA        
//      GET_FBA_QUORUMSET,        
//      FBA_QUORUMSET,    
//      FBA_MESSAGE
//  };

//  ===========================================================================
public enum MessageType implements XdrElement {
  ERROR_MSG(0),
  HELLO(1),
  DONT_HAVE(2),
  GET_PEERS(3),
  PEERS(4),
  GET_TX_SET(5),
  TX_SET(6),
  GET_VALIDATIONS(7),
  VALIDATIONS(8),
  TRANSACTION(9),
  JSON_TRANSACTION(10),
  GET_FBA_QUORUMSET(11),
  FBA_QUORUMSET(12),
  FBA_MESSAGE(13),
  ;
  private int mValue;

  MessageType(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static MessageType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return ERROR_MSG;
      case 1: return HELLO;
      case 2: return DONT_HAVE;
      case 3: return GET_PEERS;
      case 4: return PEERS;
      case 5: return GET_TX_SET;
      case 6: return TX_SET;
      case 7: return GET_VALIDATIONS;
      case 8: return VALIDATIONS;
      case 9: return TRANSACTION;
      case 10: return JSON_TRANSACTION;
      case 11: return GET_FBA_QUORUMSET;
      case 12: return FBA_QUORUMSET;
      case 13: return FBA_MESSAGE;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, MessageType value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}
