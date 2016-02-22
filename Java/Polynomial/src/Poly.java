import java.util.ArrayList;

/**
 * Created by sameenislam on 04/02/2016.
 * Polynomial implemented as an Arraylist of (exp, coeff) pairs.
 * Must be stored in ascending numerical order of exponent, with
 * no coefficients of 0.
 */
public class Poly {
    // each element holds a pair which is a term
    private ArrayList<Term> terms;

    // (coeff)x^(exp)
    public Poly() {
        terms = new ArrayList<Term>();
    }

    // (exponent, coefficient) pair
    public Poly(int e, int c) throws NegativeExponentException {
        this();
        if(c<0)
            throw new NegativeExponentException();
        if(e!=0)
            terms.add(new Term(e,c));
    }

    // store a new term
    private Poly(ArrayList<Term> t) {
        terms=t;
    }

    // TODO: find out the logic of this code
    // add the polynomial term given, to the one we already had
    public Poly add(Poly q) throws  NullPointerException {
        ArrayList<Term> addterms = new ArrayList<Term>();
        int i=0,j=0;
        while(i<terms.size()&&j<q.terms.size()) {
            Term p1=terms.get(i);
            Term p2=q.terms.get(j);
            if(p1.exp<p2.exp) // maintaining order
            {
                addterms.add(p1);
                i++;
            }
            else if(p2.exp<p1.exp)
            {
                addterms.add(p2);
                j++;
            }
            else
            {
                if(p1.coeff+p2.coeff!=0)
                    addterms.add(new Term(p1.coeff+p2.coeff,p1.exp)); // what's this?
                i++;
                j++;
            }
        }
        for(;i<terms.size();i++) // why is i not init at 0?
            addterms.add(terms.get(i));
        for(;j<q.terms.size();j++)
            addterms.add(q.terms.get(j));
        return new Poly(addterms);
    }

    // getter for m
    /*A method coeff which takes an integer d and returns the coefficient
    of the term of the polynomial it is called on whose exponent is d.
    So if mxn is a term of the polynomial p, thenp.coeff(n)returns m.
    ForthefirstPolyabove,withargument2itshouldreturn -3.
    */
    public int coeff(int d) {

       for(Term p : terms) {
           // find the term whose exp == d. Then return its exp from the pair
           if(p.exp==d)
               return p.coeff;
           else if(p.exp>d)
               return 0; // no matching coeff was found
       }
        return 0; // list exausted, but nothing found
    }


    public int degree() {
        // Note: terms is the arraylist w/ (exp, coeff)
        int last = terms.size()-1;
        return terms.get(last).exp;
    }

    // a term is a (exp, coeff) pair
    private static class Term {
        int coeff, exp; // these aren't private, so accessable from anywhere

        Term(int c, int e) {
            coeff=c;
            exp=e;
        }

    }


}
