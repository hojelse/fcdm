# Natural deduction in predicate logic

### Natural deduction [Wikipedia](https://en.wikipedia.org/wiki/Natural_deduction)
> In logic and proof theory, natural deduction is a kind of proof calculus in which logical reasoning is expressed by inference rules closely related to the "natural" way of reasoning. This contrasts with Hilbert-style systems, which instead use axioms as much as possible to express the logical laws of deductive reasoning.

### Predicate (Mathematical logic) [Wikipedia](https://en.wikipedia.org/wiki/Predicate_(mathematical_logic))
> In mathematical logic, a predicate is commonly understood to be a Boolean-valued function P: X→ {true, false}, called a predicate on X. However, predicates have many different uses and interpretations in mathematics and logic, and their precise definition, meaning and use will vary from theory to theory.

### Rule of inference [Wikipedia](https://en.wikipedia.org/wiki/Rule_of_inference)
> In formal logic (and many related areas), rules of inference are usually given in the following standard form:
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

The inference (deduction, derivation) below shows the use of the specific rule *Implication Elimination* (→E) which is put as a label to the right of the horizontal line (which indicates 1 inference step)

```
a      a -> b
_____________ →E
     b
```

```
Its snowing    Its snowing -> Its cold
______________________________________ →E
               Its cold
```

