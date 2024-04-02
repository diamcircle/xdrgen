// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package MyXDR;

import java.io.IOException;

import static MyXDR.Constants.*;
import org.diamnet.sdk.Base64Factory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Objects;
import java.util.Arrays;

// === xdr source ============================================================

//  union MyUnion switch (UnionKey type)
//  {
//      case ERROR:
//          Error error;
//      case MULTI:
//          Multi things<>;
//  
//  
//  };

//  ===========================================================================
public class MyUnion implements XdrElement {
  public MyUnion () {}
  UnionKey type;
  public UnionKey getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(UnionKey value) {
    this.type = value;
  }
  private Error error;
  public Error getError() {
    return this.error;
  }
  public void setError(Error value) {
    this.error = value;
  }
  private Multi[] things;
  public Multi[] getThings() {
    return this.things;
  }
  public void setThings(Multi[] value) {
    this.things = value;
  }

  public static final class Builder {
    private UnionKey discriminant;
    private Error error;
    private Multi[] things;

    public Builder discriminant(UnionKey discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder error(Error error) {
      this.error = error;
      return this;
    }

    public Builder things(Multi[] things) {
      this.things = things;
      return this;
    }

    public MyUnion build() {
      MyUnion val = new MyUnion();
      val.setDiscriminant(discriminant);
      val.setError(this.error);
      val.setThings(this.things);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, MyUnion encodedMyUnion) throws IOException {
  //Xdrgen::AST::Identifier
  //UnionKey
  stream.writeInt(encodedMyUnion.getDiscriminant().getValue());
  switch (encodedMyUnion.getDiscriminant()) {
  case ERROR:
  Error.encode(stream, encodedMyUnion.error);
  break;
  case MULTI:
  int thingssize = encodedMyUnion.getThings().length;
  stream.writeInt(thingssize);
  for (int i = 0; i < thingssize; i++) {
    Multi.encode(stream, encodedMyUnion.things[i]);
  }
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static MyUnion decode(XdrDataInputStream stream) throws IOException {
  MyUnion decodedMyUnion = new MyUnion();
  UnionKey discriminant = UnionKey.decode(stream);
  decodedMyUnion.setDiscriminant(discriminant);
  switch (decodedMyUnion.getDiscriminant()) {
  case ERROR:
  decodedMyUnion.error = Error.decode(stream);
  break;
  case MULTI:
  int thingssize = stream.readInt();
  decodedMyUnion.things = new Multi[thingssize];
  for (int i = 0; i < thingssize; i++) {
    decodedMyUnion.things[i] = Multi.decode(stream);
  }
  break;
  }
    return decodedMyUnion;
  }
  @Override
  public int hashCode() {
    return Objects.hash(this.error, Arrays.hashCode(this.things), this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof MyUnion)) {
      return false;
    }

    MyUnion other = (MyUnion) object;
    return Objects.equals(this.error, other.error) && Arrays.equals(this.things, other.things) && Objects.equals(this.type, other.type);
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

  public static MyUnion fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static MyUnion fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
