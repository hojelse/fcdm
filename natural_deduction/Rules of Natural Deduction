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

#### Disjunction ``∨``

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

#### True and false ``T`` ``F``

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

#### Negation ``¬``

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

#### Quantifiers

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
