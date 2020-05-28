# Propositional logic exercises
Excercise answers from basic-exercises.pdf

## Excercise 1

### 1.10.
(((S ∧ R) ∨ (Q ∧ P)) ∨ ((P ∧ Q) ∨ (R ∧ S))) → ((P ∨ S) ∨ (Q ∨ R))
```
Require Import ProofWeb.

Parameter S R Q P : Prop.

Theorem exercise_1_10 : (((S /\ R) \/ (Q /\ P)) \/ ((P /\ Q) \/ (R /\ S))) -> ((P \/ S) \/ (Q \/ R)).

imp_i h1.
dis_e (((S /\ R) \/ (Q /\ P)) \/ ((P /\ Q) \/ (R /\ S))) h2 h3.
exact h1.
dis_e ((S /\ R) \/ (Q /\ P)) h4 h5.
exact h2.
dis_i1.
dis_i2.
con_e1 R.
exact h4.
dis_i1.
dis_i1.
con_e2 Q.
exact h5.
dis_e ((P /\ Q) \/ (R /\ S)) h6 h7.
exact h3.
dis_i1.
dis_i1.
con_e1 Q.
exact h6.
dis_i1.
dis_i2.
con_e2 R.
exact h7.​

Proof.

Qed.
```
```
                                                         [S ∧ R]h4           [Q ∧ P]h5                                   [P ∧ Q]h6           [R ∧ S]h7                                  
                                                         ───────── ∧e₁       ───────── ∧e₂                               ───────── ∧e₁       ───────── ∧e₂                              
                                                             S                   P                                           P                   S                                      
                                                         ───────── ∨i₂       ───────── ∨i₁                               ───────── ∨i₁       ───────── ∨i₂                              
                                                           P ∨ S               P ∨ S                                       P ∨ S               P ∨ S                                    
                                                      ─────────────── ∨i₁ ─────────────── ∨i₁                         ─────────────── ∨i₁ ─────────────── ∨i₁                           
                                    [S ∧ R ∨ Q ∧ P]h2 (P ∨ S) ∨ Q ∨ R     (P ∨ S) ∨ Q ∨ R           [P ∧ Q ∨ R ∧ S]h3 (P ∨ S) ∨ Q ∨ R     (P ∨ S) ∨ Q ∨ R                               
                                    ───────────────────────────────────────────────────── ∨e[h4,h5] ───────────────────────────────────────────────────── ∨e[h6,h7]                     
[(S ∧ R ∨ Q ∧ P) ∨ P ∧ Q ∨ R ∧ S]h1                    (P ∨ S) ∨ Q ∨ R                                                 (P ∨ S) ∨ Q ∨ R                                                  
───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────── ∨e[\/,P,/\,Q,\/,R,/\,S),h2,h3]
                                                                     (P ∨ S) ∨ Q ∨ R                                                                                                    
───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────── →i[h1]                        
                                                    (S ∧ R ∨ Q ∧ P) ∨ P ∧ Q ∨ R ∧ S → (P ∨ S) ∨ Q ∨ R                                                                                   
```

## Excercise 1

### 1.10.
