- [Natural deduction](#natural-deduction)
- [Propositional logic](#propositional-logic)
- [Predicate logic](#predicate-logic)
- [Proofweb](#proofweb)
- [Rules of inference](#rules-of-inference)
  * [Gentzen style notation with examples](#gentzen-style-notation-with-examples)
- [Intuitionistic rules](#intuitionistic-rules)
  * [Conjunction rules ``∧``](#conjunction-rules------)
  * [Implication rules ``→``](#implication-rules------)
  * [Disjunction rules ``∨``](#disjunction------)
  * [True and false rules ``T`` ``F``](#true-and-false---t-----f--)
  * [Negation rules ``¬``](#negation------)
- [Classical rules](#classical-rules)
  * [Classical rules](#classical-rules-1)
  * [Quantifiers](#quantifiers)

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
>──────────
>conclusion
>```
>[Wikipedia](https://en.wikipedia.org/wiki/Rule_of_inference)

#### Gentzen style notation with examples
The Gentzen style (horizontal tree-like notation) is used in this folder

```
premise 1    premise 2   ...   premise n
────────────────────────────────────────
              conclusion
```

```
              premise 2        premise 3
              ──────────────────────────
premise 1            conclusion 1
────────────────────────────────────────
             conclusion 2
```

The inference (synonyms: deduction, derivation) below shows the use of the specific rule *Implication Elimination* (also called modus ponens)

*Implication Elimination* is labelled →E, and is placed to the right of the horizontal line

Horizontal line indicates 1 inference step

```
a       a → b
───────────── →E
      b
```

```
Its snowing    Its snowing → Its cold
───────────────────────────────────── →E
              Its cold
```

See the full list of inference rules in the document [Rules of Natural Deduction in Predicate Logic.png](https://github.com/hojelse/fcdm/blob/master/natural_deduction/README.md)

### Intuitionistic rules

[Wikipedia: Intuitionistic logic](https://en.wikipedia.org/wiki/Intuitionistic_logic)

#### Conjunction rules ``∧``

Conjunction Introduction ``∧I``
```
A true    B true
──────────────── ∧I
   A ∧ B true
```

Conjunction Elimination Left ``∧E1``
```
A ∧ B true
────────── ∧E1
  A true
```

Conjunction Elimination Right ``∧E2``
```
A ∧ B true
────────── ∧E2
  B true
```

#### Implication rules ``→``

Implication Introduction ``→I[u]``
```
  ────── u
  A true
     ⋮
  B true
────────── →I[u]
A → B true
```

Implication Elimination ``→E``
```
A → B true    A true
──────────────────── →E
       B true
```

#### Disjunction rules ``∨``

Disjunction Introduction Left ``∨I1``
```
  A true
────────── ∨I1
A ∨ B true
```

Disjunction Introduction Right ``∨I2``
```
  B true
────────── ∨I2
A ∨ B true
```

Disjunction Elimination ``∨E[u,v]``
```
            ────── u  ────── v
            A true    B true
               ⋮         ⋮
A ∨ B true  C true    C true
────────────────────────── ∨E[u,v]
           C true
```

#### True and false rules ``T`` ``F``

True Introduction (Unit) ``TI``

```
  ────── TI
  T true
```

False Elimination ``FE`` or ``⊥E``

```
⊥ true
────── ⊥E
C true
```

#### Negation rules ``¬``

Negation Introduction ``¬I[u]``
```
 ────── u
 A true
    ⋮
 ⊥ true
──────── ¬I[u]
¬A true
```

Law of Excluded Middel or Negation Elimination ``¬E``
```
¬A true    A true
───────────────── ¬E
     C true
```

### Classical rules
A superset of Intuistic rules where Quantifiers are allowed

[Wikipedia: Classical logic](https://en.wikipedia.org/wiki/Classical_logic)

#### Classical rules

Law of Excluded Middel ``LEM``
```
──────────────── LEM
A true ∨ ¬A true
```

Double Negation Elimination ``¬¬C``
```
¬¬A true
──────── ¬¬C
 A true
```

Prove By Contradiction ``PBC[u]``
```
──────── u
¬A true
   ⋮
 ⊥ true
──────── PBC[u]
 A true
```

#### Quantifiers ``∀`` ``∃``

Universal Introduction ``∀I[a]``

```
A[a/x] true
─────────── ∀I[a]
∀x(A) true
```

Universal Elimination ``∀E``

```
∀x(A) true
─────────── ∀E
A[t/x] true
```

Existential Elimination ``∃I``

```
A[t/x] true
─────────── ∃I
∃x(A) true
```

Universal Elimination ``∃E[a,u]``

```
              ─────────── u
              A[a/x] true
                   ⋮
∃x(A) true      C true
────────────────────── ∃E[a,u]
        C true
```

