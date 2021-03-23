public class Square
{
  private int value;
  private boolean penny = false;

  public Square(int v)
  {
    value = v;
  }

  public void reset()
  {
    penny = false;
  }

  public int hit()
  {
    int localValue = getValue();
    penny = true;
    return localValue;
  }

  public int getValue()
  {
    if (penny)
    {
      return 0;
    }
    return value;
  }

  public String toString()
  {
    return "Value: " + value + " | Has Penny?: " + penny;
  }
}