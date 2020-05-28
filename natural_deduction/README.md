# Natural deduction in propositional logic

Assignments and answers

### Proofweb

Tool for double checking proofs [proofweb](http://proofweb.cs.ru.nl/)

I used Guest login, Coq prover, settings: display:Gentzen style and template:Theorem template

### Natural deduction
> In logic and proof theory, natural deduction is a kind of proof calculus in which logical reasoning is expressed by inference rules closely related to the "natural" way of reasoning. This contrasts with Hilbert-style systems, which instead use axioms as much as possible to express the logical laws of deductive reasoning. [Wikipedia](https://en.wikipedia.org/wiki/Natural_deduction)

### Rule of inference
> In formal logic (and many related areas), rules of inference are usually given in the following standard form: [Wikipedia](https://en.wikipedia.org/wiki/Rule_of_inference)
> ```
>premise 1
>premise 2
>...
>premise n
>_________
>conclusion
>```
>

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
