// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package MyXDR;

import java.io.IOException;

import static MyXDR.Constants.*;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

// === xdr source ============================================================

//  struct LotsOfMyStructs
//  {
//      MyStruct members<>;
//  };

//  ===========================================================================
public class LotsOfMyStructs implements XdrElement {
  public LotsOfMyStructs () {}
  private MyStruct[] members;
  public MyStruct[] getMembers() {
    return this.members;
  }
  public void setMembers(MyStruct[] value) {
    this.members = value;
  }
  public static void encode(XdrDataOutputStream stream, LotsOfMyStructs encodedLotsOfMyStructs) throws IOException{
    int memberssize = encodedLotsOfMyStructs.getMembers().length;
    stream.writeInt(memberssize);
    for (int i = 0; i < memberssize; i++) {
      MyStruct.encode(stream, encodedLotsOfMyStructs.members[i]);
    }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static LotsOfMyStructs decode(XdrDataInputStream stream) throws IOException {
    LotsOfMyStructs decodedLotsOfMyStructs = new LotsOfMyStructs();
    int memberssize = stream.readInt();
    decodedLotsOfMyStructs.members = new MyStruct[memberssize];
    for (int i = 0; i < memberssize; i++) {
      decodedLotsOfMyStructs.members[i] = MyStruct.decode(stream);
    }
    return decodedLotsOfMyStructs;
  }
  @Override
  public int hashCode() {
    return Arrays.hashCode(this.members);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LotsOfMyStructs)) {
      return false;
    }

    LotsOfMyStructs other = (LotsOfMyStructs) object;
    return Arrays.equals(this.members, other.members);
  }

  @Override
  public String toXdrBase64() throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    return base64Encoding.encode(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static LotsOfMyStructs fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LotsOfMyStructs fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
  public static final class Builder {
    private MyStruct[] members;

    public Builder members(MyStruct[] members) {
      this.members = members;
      return this;
    }

    public LotsOfMyStructs build() {
      LotsOfMyStructs val = new LotsOfMyStructs();
      val.setMembers(this.members);
      return val;
    }
  }
}
