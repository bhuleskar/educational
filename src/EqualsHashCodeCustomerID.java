import java.util.HashMap;
import java.util.Map;

public class EqualsHashCodeCustomerID {
  private long crmID;
  private int nameSpace;

  public EqualsHashCodeCustomerID(long crmID, int nameSpace) {
    super();
    this.crmID = crmID;
    this.nameSpace = nameSpace;
  }

  public boolean equals(Object obj) {
    //null instanceof Object will always return false
    if (!(obj instanceof EqualsHashCodeCustomerID))
      return false;
    if (obj == this)
      return true;
    return  this.crmID == ((EqualsHashCodeCustomerID) obj).crmID &&
            this.nameSpace == ((EqualsHashCodeCustomerID) obj).nameSpace;
  }

  public int hashCode() {
    int result = 0;
    result = (int)(crmID/12) + nameSpace;
    return result;
  }

  public static void main(String[] args) {
    Map m = new HashMap();
    m.put(new EqualsHashCodeCustomerID(2345891234L,0),"Jeff Smith");
    System.out.println(m.get(new EqualsHashCodeCustomerID(2345891234L,0)));
  }

}
