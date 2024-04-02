// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package MyXDR;

import java.io.IOException;

import static MyXDR.Constants.*;
import org.diamnet.sdk.Base64Factory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

// === xdr source ============================================================

//  typedef string str<64>;

//  ===========================================================================
public class Str implements XdrElement {
  private XdrString str;

  public Str() {}

  public Str(XdrString str) {
    this.str = str;
  }

  public XdrString getStr() {
    return this.str;
  }

  public void setStr(XdrString value) {
    this.str = value;
  }

  public static void encode(XdrDataOutputStream stream, Str  encodedStr) throws IOException {
    encodedStr.str.encode(stream);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Str decode(XdrDataInputStream stream) throws IOException {
    Str decodedStr = new Str();
    decodedStr.str = XdrString.decode(stream, 64);
    return decodedStr;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.str);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Str)) {
      return false;
    }

    Str other = (Str) object;
    return Objects.equals(this.str, other.str);
  }
  @Override
  public String toXdrBase64() throws IOException {
    return Base64Factory.getInstance().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static Str fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static Str fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
