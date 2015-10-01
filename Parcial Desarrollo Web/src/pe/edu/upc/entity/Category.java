package pe.edu.upc.entity;

public class Category 
{
    private int idcategory;
    private String name;

    public Category() 
    {
        
    }

    public int getIdcategory() {return idcategory;}
    public void setIdcategory(int idcategory) {this.idcategory = idcategory;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString()
    {
        return "Category{" + "idcategory=" + idcategory + ", name=" + name + '}';
    }


    
}
