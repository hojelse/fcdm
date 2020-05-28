# Natural deduction

Assignments and answers

### Natural deduction

Synonyms for deduct: infer, derive

> In logic and proof theory, natural deduction is a kind of proof calculus in which logical reasoning is expressed by inference rules closely related to the "natural" way of reasoning. This contrasts with Hilbert-style systems, which instead use axioms as much as possible to express the logical laws of deductive reasoning. [Wikipedia](https://en.wikipedia.org/wiki/Natural_deduction)

### Propositional logic

*Proposition* a statement proposing an idea that can be true or false.

Synonyms for proposition: premise

Letters (e.g. A, B, C) are used as abstract placeholders for concrete propositions (e.g. "it's snowing", "a dog is an animal", "the moon is made of cheese")

[Wikipedia: Propositional calculus](https://en.wikipedia.org/wiki/Propositional_calculus)

### Predicate logic

*Predicate* in traditional grammar is the verb part of a sentence. In "Socrates is mortal", Socrates is the subject, and is mortal is the predicate, which modifies the description of the subject.

In formal logic predicates are functions taking a variables (e.g. isEven(x), isMortal(Socrates)) 

Predicate logic is also known as First order logic

[Wikipedia: First order logic](https://en.wikipedia.org/wiki/First-order_logic)

### Proofweb

Tool for double checking proofs [proofweb](http://proofweb.cs.ru.nl/)

I used Guest login, Coq prover, settings: display:Gentzen style and template:Theorem template

### Rules of inference
> In formal logic (and many related areas), rules of inference are usually given in the following standard form:
> ```
>premise 1
>premise 2
>...
>premise n
>_________
>conclusion
>```
>[Wikipedia](https://en.wikipedia.org/wiki/Rule_of_inference)

#### Gentzen style notation with examples
The Gentzen style (horizontal tree-like notation) is used in this folder

```
premise 1    premise 2   ...   premise n
________________________________________
              conclusion
```

```
              premise 2        premise 3
              __________________________
premise 1            conclusion 1
________________________________________
             conclusion 2
```

The inference (synonyms: deduction, derivation) below shows the use of the specific rule *Implication Elimination* (also called modus ponens)

*Implication Elimination* is labelled →E, and is placed to the right of the horizontal line

Horizontal line indicates 1 inference step

```
a       a → b
_____________ →E
      b
```

```
Its snowing    Its snowing → Its cold
_____________________________________ →E
              Its cold
```

See the full list of inference rules in the document [Rules of Natural Deduction in Predicate Logic.png](https://github.com/hojelse/fcdm/blob/master/natural_deduction/README.md)

### Intuitionistic rules


### Classical rules

A superset of Intuistic rules where Quantifiers are allowed
