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

//  typedef int Multi;

//  ===========================================================================
public class Multi implements XdrElement {
  private Integer Multi;

  public Multi() {}

  public Multi(Integer Multi) {
    this.Multi = Multi;
  }

  public Integer getMulti() {
    return this.Multi;
  }

  public void setMulti(Integer value) {
    this.Multi = value;
  }

  public static void encode(XdrDataOutputStream stream, Multi  encodedMulti) throws IOException {
    stream.writeInt(encodedMulti.Multi);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Multi decode(XdrDataInputStream stream) throws IOException {
    Multi decodedMulti = new Multi();
    decodedMulti.Multi = stream.readInt();
    return decodedMulti;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.Multi);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Multi)) {
      return false;
    }

    Multi other = (Multi) object;
    return Objects.equals(this.Multi, other.Multi);
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

  public static Multi fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static Multi fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
