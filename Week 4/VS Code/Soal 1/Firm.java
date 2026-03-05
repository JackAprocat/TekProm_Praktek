//********************************************************************
// Firm.java Author: Lewis/Loftus
//
// Demonstrates polymorphism via inheritance.
//********************************************************************
public class Firm{
//-----------------------------------------------------------------
// Creates a staff of employees for a firm and pays them.
//-----------------------------------------------------------------
    public static void main (String[] args){
        Staff personnel = new Staff();
        personnel.payday();
    }
}

//********************************************************************
// Staff.java Author: Lewis/Loftus
//
// Represents the personnel staff of a particular business.
//********************************************************************
