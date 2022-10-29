// Name: Nisarg Doshi
//Student #: 501109700
public class Shoes extends Product
{
  //Below are two arrays that I have initialized with 5 elements each in which each index represents the stock count 
  //of each size of shoes (6, 7, 8, 9 and 10) in the indicated colour in the array name
  private int[] blackShoeCombinations = new int[5]; 
  //blackShoeCombinations[0] -> the stock count of black shoes, size 6
  //blackShoeCombinations[1] -> the stock count of black shoes, size 7
  //blackShoeCombinations[2] -> the stock count of black shoes, size 8
  //blackShoeCombinations[3] -> the stock count of black shoes, size 9
  //blackShoeCombinations[4] -> the stock count of black shoes, size 10
  private int[] brownShoeCombinations = new int[5];
  //brownShoeCombinations[0]] -> the stock count of brown shoes, size 6
  //brownShoeCombinations[1] -> the stock count of brown shoes, size 7
  //brownShoeCombinations[2] -> the stock count of brown shoes, size 8
  //brownShoeCombinations[3] -> the stock count of brown shoes, size 9
  //brownShoeCombinations[4] -> the stock count of brown shoes, size 10
  public Shoes(String name, String id, double price, int stock, Category category)
  {
      super(name, id, price, stock, Product.Category.SHOES);
  }
  // Check if a valid format  
  public boolean validOptions(String productOptions)
  {
      if (productOptions.equalsIgnoreCase("black6") || productOptions.equalsIgnoreCase("black7") || productOptions.equalsIgnoreCase("black8") || productOptions.equalsIgnoreCase("black9") || productOptions.equalsIgnoreCase("black10"))
      {
          return true;
      }
      else if (productOptions.equalsIgnoreCase("brown6") || productOptions.equalsIgnoreCase("brown7") || productOptions.equalsIgnoreCase("brown8") || productOptions.equalsIgnoreCase("brown9") || productOptions.equalsIgnoreCase("brown10"))
      {
          return true;
      }
      else
      {
          return false;
      }
  }
  // Method for getting the stock count for each type of shoe
  public int getStockCount(String productOptions)
  {
    if (productOptions.equalsIgnoreCase("black6"))
    {
        blackShoeCombinations[0]++;
        return blackShoeCombinations[0];
    }
    else if (productOptions.equalsIgnoreCase("black7"))
    {
        blackShoeCombinations[1]++;
        return blackShoeCombinations[1];
    }
    else if (productOptions.equalsIgnoreCase("black8"))
    {
        blackShoeCombinations[2]++;
        return blackShoeCombinations[2];
    }
    else if (productOptions.equalsIgnoreCase("black9"))
    {
        blackShoeCombinations[3]++;
        return blackShoeCombinations[3];
    }
    else if (productOptions.equalsIgnoreCase("black10"))
    {
        blackShoeCombinations[4]++;
        return blackShoeCombinations[4];
    }
    else if (productOptions.equalsIgnoreCase("brown6"))
    {
        brownShoeCombinations[0]++;
        return brownShoeCombinations[0];
    }
    else if (productOptions.equalsIgnoreCase("brown7"))
    {
        brownShoeCombinations[1]++;
        return brownShoeCombinations[1];
    }
    else if (productOptions.equalsIgnoreCase("brown8"))
    {
        brownShoeCombinations[2]++;
        return brownShoeCombinations[2];
    }
    else if (productOptions.equalsIgnoreCase("brown9"))
    {
        brownShoeCombinations[3]++;
        return brownShoeCombinations[3];
    }
    else if (productOptions.equalsIgnoreCase("brown10"))
    {
        brownShoeCombinations[4]++;
        return brownShoeCombinations[4];
    }
    else
    {
        return 0;
    }
  }
  // Method for setting the stock count of each type of shoe to a given integer stockCount parameter 
  public void setStockCount(int stockCount, String productOptions)
  {
      if (productOptions.equalsIgnoreCase("black6"))
      {
          blackShoeCombinations[0] = stockCount;
      }
      else if (productOptions.equalsIgnoreCase("black7"))
      {
          blackShoeCombinations[1] = stockCount;
      }
      else if (productOptions.equalsIgnoreCase("black8"))
      {
          blackShoeCombinations[2] = stockCount;
      }
      else if (productOptions.equalsIgnoreCase("black9"))
      {
          blackShoeCombinations[3] = stockCount;
      }
      else if (productOptions.equalsIgnoreCase("black10"))
      {
          blackShoeCombinations[4] = stockCount;
      }
      else if (productOptions.equalsIgnoreCase("brown6"))
      {
          brownShoeCombinations[0] = stockCount;
      }
      else if (productOptions.equalsIgnoreCase("brown7"))
      {
          brownShoeCombinations[1] = stockCount;
      }
      else if (productOptions.equalsIgnoreCase("brown8"))
      {
          brownShoeCombinations[2] = stockCount;
      }
      else if (productOptions.equalsIgnoreCase("brown9"))
      {
          brownShoeCombinations[3] = stockCount;
      }
      else if (productOptions.equalsIgnoreCase("brown10"))
      {
          brownShoeCombinations[4] = stockCount;
      }
  }
  //When a shoe is ordered, reduce the stock count for the specific stock type
  public void reduceStockCount(String productOptions)
  {
      if (productOptions.equalsIgnoreCase("black6"))
      {
          blackShoeCombinations[0]--;
      }
      else if (productOptions.equalsIgnoreCase("black7"))
      {
          blackShoeCombinations[1]--;
      }
      else if (productOptions.equalsIgnoreCase("black8"))
      {
          blackShoeCombinations[2]--;
      }
      else if (productOptions.equalsIgnoreCase("black9"))
      {
          blackShoeCombinations[3]--;
      }
      else if (productOptions.equalsIgnoreCase("black10"))
      {
          blackShoeCombinations[4]--;
      }
      else if (productOptions.equalsIgnoreCase("brown6"))
      {
          brownShoeCombinations[0]--;
      }
      else if (productOptions.equalsIgnoreCase("brown7"))
      {
          brownShoeCombinations[1]--;
      }
      else if (productOptions.equalsIgnoreCase("brown8"))
      {
          brownShoeCombinations[2]--;
      }
      else if (productOptions.equalsIgnoreCase("brown9"))
      {
          brownShoeCombinations[3]--;
      }
      else if (productOptions.equalsIgnoreCase("brown10"))
      {
          brownShoeCombinations[4]--;
      }
    }//Prints product information from super class 
    public void print()
    {
        super.print();
    }
}
