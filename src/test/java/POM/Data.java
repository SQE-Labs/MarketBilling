package POM;

public class Data {
    public enum firstName {
        Liam, Olivia, Noah, Ava, Oliver, Charlotte, Jack, William, Amelia, Lucas, Harper, Ethan, Isla, Henry, Grace, Mason, Ella, James, Lily, Thomas, Chloe, Jackson, Zoe, Max, Ruby, Samuel, Evie, Alexander, Emily, Charlie, Sophie, Daniel, Scarlett, Harrison, Isabella, Sebastian, Benjamin, Matilda, Leo, Lucy, Cooper, Abigail, Joshuan, Xavier, Archer, Lincoln, Willow, Logan, Ivy, Jordan, Georgia, Caleb, Annabelle, Toby, Aurora, Aaron, Madison, Michael, Sienna, Mitchell, Aria, Nate, Patrick, Ellie, Jesse, Hannah, Blake;

        public static firstName getFirstName() {
            return values()[(int) (Math.random() * values().length)];
        }

    }

    public enum customerType {
        Tenant;

        public static customerType getCustomerType() {
            return values()[(int) (Math.random() * values().length)];
        }

    }



    public enum surName {
        Smith, Jones, Williams, Brown, Patel, Taylor, Anderson, Thomas, Johnson, Nguyen, Wilson, White, Lee, Harris, Wong, Chen, Kumar, Wang, Davis, Miller, Garcia, Rodriguez, Martin, Khan, Cooper, Lewis, Hall, Jackson, Clarke, Hill, Turner, Baker, Green, Adams, Ali, Li, Scott, Mitchell, Campbell, Yang, Hooper, Murray, Gray, Roberts, Cox, Bell, Brooks, Wood, Grant, Evans;

        public static surName getSurName() {
            return values()[(int) (Math.random() * values().length)];
        }
    }


}