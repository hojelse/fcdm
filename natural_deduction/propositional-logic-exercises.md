# Propositional logic exercises
Excercise answers from basic-exercises.pdf

## Excercise 1

### 1.1.
((P ∧ Q) ∧ R) → (S ∧ T) → (Q ∧ S)
```
[(P ∧ Q) ∧ R]h1                     
─────────────── ∧e₁                 
     P ∧ Q          [S ∧ T]h2       
─────────────── ∧e₂ ───────── ∧e₁   
       Q                S           
───────────────────────────── ∧i    
            Q ∧ S                   
───────────────────────────── →i[h2]
        S ∧ T → Q ∧ S               
───────────────────────────── →i[h1]
 (P ∧ Q) ∧ R → S ∧ T → Q ∧ S        
```
<details>
  <summary>Proofweb</summary>
  
```
Require Import ProofWeb.

Parameter P Q R S T : Prop.

Theorem exercise_1_1 : ((P /\ Q) /\ R) -> (S /\ T) -> (Q /\ S).
imp_i h1.
imp_i h2.
con_i.
con_e2 P.
con_e1 R.
exact h1.
con_e1 T.
exact h2.

Proof.

Qed.
```
</details>

### 1.2.
(P ∧ (Q ∧ S)) → ((P ∧ Q) ∧ S)
```
                  [P ∧ Q ∧ S]h1                         
                  ───────────── ∧e₂                     
[P ∧ Q ∧ S]h1         Q ∧ S         [P ∧ Q ∧ S]h1       
───────────── ∧e₁ ───────────── ∧e₁ ───────────── ∧e₂   
      P                 Q               Q ∧ S           
─────────────────────────────── ∧i  ───────────── ∧e₂   
             P ∧ Q                        S             
───────────────────────────────────────────────── ∧i    
                   (P ∧ Q) ∧ S                          
───────────────────────────────────────────────── →i[h1]
             P ∧ Q ∧ S → (P ∧ Q) ∧ S                    
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q S : Prop.

Theorem exercise_1_2 : (P /\ (Q /\ S)) -> ((P /\ Q) /\ S).
imp_i h1.
con_i.
con_i.
con_e1 (Q /\ S).
exact h1.
con_e1 S.
con_e2 P.
exact h1.
con_e2 Q.
con_e2 P.
exact h1.

Proof.

Qed.
``` 
</details>

### 1.3.
(P → (P → Q)) → P → Q
```
[P → P → Q]h1 [P]h2                
─────────────────── →e             
       P → Q           [P]h2       
──────────────────────────── →e    
              Q                    
──────────────────────────── →i[h2]
            P → Q                  
──────────────────────────── →i[h1]
     (P → P → Q) → P → Q           
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q : Prop.

Theorem exercise_1_3 : (P -> (P -> Q)) -> P -> Q.
imp_i h1.
imp_i h2.
imp_e P.
imp_e P.
exact h1.
exact h2.
exact h2.

Proof.

Qed.
```
</details>

### 1.4.
(P ∧ Q) → Q
```
[P ∧ Q]h1       
───────── ∧e₂   
    Q           
───────── →i[h1]
P ∧ Q → Q       
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q : Prop.

Theorem exercise_1_4 : (P /\ Q) -> Q.
imp_i h1.
con_e2 P.
exact h1.

Proof.

Qed.
```
</details>

### 1.5.
P → Q → P
```
  [P]h1         
  ───── →i[h2]  
  Q → P         
───────── →i[h1]
P → Q → P       
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q : Prop.

Theorem exercise_1_5 : P -> Q -> P.
imp_i h1.
imp_i h2.
exact h1.

Proof.

Qed.
```
</details>

### 1.6.
(P ∧ Q) ∨ (Q ∧ R) → Q
```
                  [P ∧ Q]h2     [Q ∧ R]h3          
                  ───────── ∧e₂ ───────── ∧e₁      
[P ∧ Q ∨ Q ∧ R]h1     Q             Q              
───────────────────────────────────────── ∨e[h2,h3]
                    Q                              
───────────────────────────────────────── →i[h1]   
            P ∧ Q ∨ Q ∧ R → Q                      
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R : Prop.

Theorem exercise_1_6 : (P /\ Q) \/ (Q /\ R) -> Q.
imp_i h1.
dis_e (P /\ Q \/ Q /\ R) h2 h3.
exact h1.
con_e2 P.
exact h2.
con_e1 R.
exact h3.

Proof.

Qed.
```
</details>

### 1.7.
(P → Q) → (R → S) → (P ∧ R) → (Q ∧ S)
```
          [P ∧ R]h3               [P ∧ R]h3       
          ───────── ∧e₁           ───────── ∧e₂   
[P → Q]h1     P         [R → S]h2     R           
─────────────────── →e  ─────────────────── →e    
         Q                       S                
─────────────────────────────────────────── ∧i    
                   Q ∧ S                          
─────────────────────────────────────────── →i[h3]
               P ∧ R → Q ∧ S                      
─────────────────────────────────────────── →i[h2]
          (R → S) → P ∧ R → Q ∧ S                 
─────────────────────────────────────────── →i[h1]
     (P → Q) → (R → S) → P ∧ R → Q ∧ S            
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R S : Prop.

Theorem exercise_1_7 : (P -> Q) -> (R -> S) -> (P /\ R) -> (Q /\ S).
imp_i h1.
imp_i h2.
imp_i h3.
con_i.
imp_e P.
exact h1.
con_e1 R.
exact h3.
imp_e R.
exact h2.
con_e2 P.
exact h3.
Proof.

Qed.
```
</details>

### 1.8.
(P ∨ Q) → (Q → R) → (P → R) → R
```
          [P → R]h3 [P]h4    [Q → R]h2 [Q]h5          
          ─────────────── →e ─────────────── →e       
[P ∨ Q]h1        R                  R                 
──────────────────────────────────────────── ∨e[h4,h5]
                      R                               
──────────────────────────────────────────── →i[h3]   
                 (P → R) → R                          
──────────────────────────────────────────── →i[h2]   
            (Q → R) → (P → R) → R                     
──────────────────────────────────────────── →i[h1]   
        P ∨ Q → (Q → R) → (P → R) → R                 
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R : Prop.

Theorem exercise_1_8 : (P \/ Q) -> (Q -> R) -> (P -> R) -> R.
imp_i h1.
imp_i h2.
imp_i h3.
dis_e (P \/ Q) h4 h5.
exact h1.
imp_e P.
exact h3.
exact h4.
imp_e Q.
exact h2.
exact h5.
Proof.

Qed.
```
</details>

### 1.9.
P → (Q → (P ∨ R)) 
```
[P]h1                    
───── →i[h3]             
Q → P        [Q]h2       
────────────────── →e    
         P               
────────────────── ∨i₁   
       P ∨ R             
────────────────── →i[h2]
     Q → P ∨ R           
────────────────── →i[h1]
   P → Q → P ∨ R         
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R : Prop.

Theorem exercise_1_9 : P -> (Q -> (P \/ R)).
imp_i h1.
imp_i h2.
dis_i1.
imp_e Q.
imp_i h3.
exact h1.
exact h2.
Proof.

Qed.
```
</details>

### 1.10.
(((S ∧ R) ∨ (Q ∧ P)) ∨ ((P ∧ Q) ∨ (R ∧ S))) → ((P ∨ S) ∨ (Q ∨ R))
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
<details>
  <summary>Proofweb</summary>

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
</details>

## Excercise 2

### 2.1.
(¬P → P) → P
```
                 [¬P → P]h1 [¬P]h3          
────── LEM       ───────────────── →e       
P ∨ ¬P     [P]h2         P                  
────────────────────────────────── ∨e[h2,h3]
                 P                          
────────────────────────────────── →i[h1]   
           (¬P → P) → P                     
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P : Prop.

Theorem exercise_2_1 : (~P -> P) -> P.
imp_i h1.
dis_e (P \/ ~P) h2 h3.
LEM.
exact h2.
imp_e (~P).
exact h1.
exact h3.

Proof.

Qed.
```
</details>

### 2.2.
(P ∨ Q) → ¬Q → P
```
                [¬Q]h2 [Q]h4          
                ──────────── ¬e       
[P ∨ Q]h1 [P]h3       P               
──────────────────────────── ∨e[h3,h4]
              P                       
──────────────────────────── →i[h2]   
           ¬Q → P                     
──────────────────────────── →i[h1]   
       P ∨ Q → ¬Q → P                 
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q : Prop.

Theorem exercise_2_2 : (P \/ Q) -> ~Q -> P.
imp_i h1.
imp_i h2.
dis_e (P \/ Q) h3 h4.
exact h1.
exact h3.
neg_e Q.
exact h2.
exact h4.

Proof.

Qed.
```
</details>

### 2.3.
(P → Q) → (R → S) → (P ∨ R) → (Q ∨ S)
```
          [P → Q]h1 [P]h4     [R → S]h2 [R]h5          
          ─────────────── →e  ─────────────── →e       
                 Q                   S                 
          ─────────────── ∨i₁ ─────────────── ∨i₂      
[P ∨ R]h3      Q ∨ S               Q ∨ S               
───────────────────────────────────────────── ∨e[h4,h5]
                    Q ∨ S                              
───────────────────────────────────────────── →i[h3]   
                P ∨ R → Q ∨ S                          
───────────────────────────────────────────── →i[h2]   
           (R → S) → P ∨ R → Q ∨ S                     
───────────────────────────────────────────── →i[h1]   
      (P → Q) → (R → S) → P ∨ R → Q ∨ S                
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R S : Prop.

Theorem exercise_2_3 : (P -> Q) -> (R -> S) -> (P \/ R) -> (Q \/ S).
imp_i h1.
imp_i h2.
imp_i h3.
dis_e (P \/ R) h4 h5.
exact h3.
dis_i1.
imp_e P.
exact h1.
exact h4.
dis_i2.
imp_e R.
exact h2.
exact h5.

Proof.

Qed.
```
</details>

### 2.4.
Q → ((P ∧ Q) ∨ (¬P ∧ Q))
```
             [P]h2 [Q]h1       [¬P]h3 [Q]h1           
             ─────────── ∧i    ──────────── ∧i        
                P ∧ Q             ¬P ∧ Q              
────── LEM ────────────── ∨i₁ ────────────── ∨i₂      
P ∨ ¬P     P ∧ Q ∨ ¬P ∧ Q     P ∧ Q ∨ ¬P ∧ Q          
──────────────────────────────────────────── ∨e[h2,h3]
               P ∧ Q ∨ ¬P ∧ Q                         
──────────────────────────────────────────── →i[h1]   
             Q → P ∧ Q ∨ ¬P ∧ Q                       
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q : Prop.

Theorem exercise_2_4 : Q -> ((P /\ Q) \/ (~P /\ Q)).
imp_i h1.
dis_e (P \/ ~P) h2 h3.
LEM.
dis_i1.
con_i.
exact h2.
exact h1.
dis_i2.
con_i.
exact h3.
exact h1.

Proof.

Qed.
```
</details>

### 2.5.
(P → Q) → (¬P ∨ Q)
```
           [P → Q]h1 [P]h2                     
           ─────────────── →e                  
                  Q            [¬P]h3          
────── LEM ─────────────── ∨i₂ ────── ∨i₁      
P ∨ ¬P          ¬P ∨ Q         ¬P ∨ Q          
───────────────────────────────────── ∨e[h2,h3]
                ¬P ∨ Q                         
───────────────────────────────────── →i[h1]   
           (P → Q) → ¬P ∨ Q                    
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q : Prop.

Theorem exercise_2_5 : (P -> Q) -> (~P \/ Q).
imp_i h1.
dis_e (P \/ ~P) h2 h3.
LEM.
dis_i2.
imp_e P.
exact h1.
exact h2.
dis_i1.
exact h3.

Proof.

Qed.
```
</details>

### 2.6.
(¬P ∨ Q) → P → Q
```
           [¬P]h3 [P]h2                   
           ──────────── ¬e                
[¬P ∨ Q]h1       Q         [Q]h4          
──────────────────────────────── ∨e[h3,h4]
                Q                         
──────────────────────────────── →i[h2]   
              P → Q                       
──────────────────────────────── →i[h1]   
         ¬P ∨ Q → P → Q                   
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q : Prop.

Theorem exercise_2_6 : (~P \/ Q) -> P -> Q.
imp_i h1.
imp_i h2.
dis_e (~P \/ Q) h3 h4.
exact h1.
neg_e P.
exact h3.
exact h2.
exact h4.

Proof.

Qed.
```
</details>

### 2.7.
(P → Q) → (P → ¬Q) → ¬P
```
[P → ¬Q]h2 [P]h3    [P → Q]h1 [P]h3       
──────────────── →e ─────────────── →e    
       ¬Q                  Q              
─────────────────────────────────── ¬e    
                ⊥                       
─────────────────────────────────── ¬i[h3]
                 ¬P                       
─────────────────────────────────── →i[h2]
           (P → ¬Q) → ¬P                  
─────────────────────────────────── →i[h1]
      (P → Q) → (P → ¬Q) → ¬P             
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q : Prop.

Theorem exercise_2_7 : (P -> Q) -> (P -> ~Q) -> ~P.
imp_i h1.
imp_i h2.
neg_i h3.
neg_e Q.
imp_e P.
exact h2.
exact h3.
imp_e P.
exact h1.
exact h3.

Proof.

Qed.
```
</details>

### 2.8.
(P → ¬P) → ¬P
```
[P → ¬P]h1 [P]h2                
──────────────── →e             
       ¬P           [P]h2       
───────────────────────── ¬e    
           ⊥                  
───────────────────────── ¬i[h2]
            ¬P                  
───────────────────────── →i[h1]
      (P → ¬P) → ¬P             
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P : Prop.

Theorem exercise_2_8 : (P -> ~P) -> ~P.
imp_i h1.
neg_i h2.
neg_e P.
imp_e P.
exact h1.
exact h2.
exact h2.

Proof.

Qed.
```
</details>

### 2.9.
(P ∧ (Q ∨ R)) → ((P ∧ Q) ∨ (P ∧ R))
```
                    [P ∧ (Q ∨ R)]h1               [P ∧ (Q ∨ R)]h1                    
                    ─────────────── ∧e₁           ─────────────── ∧e₁                
                           P            [Q]h2            P            [R]h3          
                    ───────────────────────── ∧i  ───────────────────────── ∧i       
[P ∧ (Q ∨ R)]h1               P ∧ Q                         P ∧ R                    
─────────────── ∧e₂ ───────────────────────── ∨i₁ ───────────────────────── ∨i₂      
     Q ∨ R                P ∧ Q ∨ P ∧ R                 P ∧ Q ∨ P ∧ R                
─────────────────────────────────────────────────────────────────────────── ∨e[h2,h3]
                               P ∧ Q ∨ P ∧ R                                         
─────────────────────────────────────────────────────────────────────────── →i[h1]   
                        P ∧ (Q ∨ R) → P ∧ Q ∨ P ∧ R                                  
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R : Prop.

Theorem exercise_2_9 : (P /\ (Q \/ R)) -> ((P /\ Q) \/ (P /\ R)).
imp_i h1.
dis_e (Q \/ R) h2 h3.
con_e2 P.
exact h1.
dis_i1.
con_i.
con_e1 (Q \/ R).
exact h1.
exact h2.
dis_i2.
con_i.
con_e1 (Q \/ R).
exact h1.
exact h3.

Proof.

Qed.
```
</details>

### 2.10.
(P → (Q → R)) → P → (¬R) → ¬Q
```
       [P → Q → R]h1 [P]h2                
       ─────────────────── →e             
              Q → R           [Q]h4       
       ──────────────────────────── →e    
[¬R]h3               R                    
─────────────────────────────────── ¬e    
                ⊥                       
─────────────────────────────────── ¬i[h4]
                 ¬Q                       
─────────────────────────────────── →i[h3]
              ¬R → ¬Q                     
─────────────────────────────────── →i[h2]
            P → ¬R → ¬Q                   
─────────────────────────────────── →i[h1]
     (P → Q → R) → P → ¬R → ¬Q            
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R : Prop.

Theorem exercise_2_10 : (P -> (Q -> R)) -> P -> ~R -> ~Q.
imp_i h1.
imp_i h2.
imp_i h3.
neg_i h4.
neg_e R.
exact h3.
imp_e Q.
imp_e P.
exact h1.
exact h2.
exact h4.

Proof.

Qed.
```
</details>

### 2.11.
(P → Q) → (¬P → R) → (Q ∨ R)
```
           [P → Q]h1 [P]h3     [¬P → R]h2 [¬P]h4          
           ─────────────── →e  ───────────────── →e       
                  Q                    R                  
────── LEM ─────────────── ∨i₁ ───────────────── ∨i₂      
P ∨ ¬P          Q ∨ R                Q ∨ R                
──────────────────────────────────────────────── ∨e[h3,h4]
                      Q ∨ R                               
──────────────────────────────────────────────── →i[h2]   
                (¬P → R) → Q ∨ R                          
──────────────────────────────────────────────── →i[h1]   
           (P → Q) → (¬P → R) → Q ∨ R                     
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R : Prop.

Theorem exercise_2_11 : (P -> Q) -> (~P -> R) -> (Q \/ R).
imp_i h1.
imp_i h2.
dis_e (P \/ ~P) h3 h4.
LEM.
dis_i1.
imp_e P.
exact h1.
exact h3.
dis_i2.
imp_e (~P).
exact h2.
exact h4.

Proof.

Qed.
```
</details>

### 2.12.
(P → Q) → (R → ¬T) → (Q → R) → (P → ¬T)
```
                         [P → Q]h1 [P]h4        
                         ─────────────── →e     
               [Q → R]h3        Q               
               ───────────────────────── →e     
  [R → ¬tru]h2             R                    
  ────────────────────────────────────── →e     
                   ¬tru                         
  ────────────────────────────────────── →i[h4] 
                 P → ¬tru                       
  ────────────────────────────────────── →i[h3] 
            (Q → R) → P → ¬tru                  
  ────────────────────────────────────── →i[h2] 
      (R → ¬tru) → (Q → R) → P → ¬tru           
───────────────────────────────────────── →i[h1]
(P → Q) → (R → ¬tru) → (Q → R) → P → ¬tru       
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R tru : Prop.

Theorem exercise_2_12 : (P -> Q) -> (R -> ~tru) -> (Q -> R) -> (P -> ~tru).
imp_i h1.
imp_i h2.
imp_i h3.
imp_i h4.
imp_e R.
exact h2.
imp_e Q.
exact h3.
imp_e P.
exact h1.
exact h4.

Proof.

Qed.
```
</details>

### 2.13.
((P ∧ ¬Q) → R) → (¬R) → P → Q
```
                      [P]h3 [¬Q]h4        
                      ──────────── ∧i     
       [P ∧ ¬Q → R]h1    P ∧ ¬Q           
       ─────────────────────────── →e     
[¬R]h2              R                     
────────────────────────────────── ¬e     
                ⊥                       
────────────────────────────────── PBC[h4]
                 Q                        
────────────────────────────────── →i[h3] 
               P → Q                      
────────────────────────────────── →i[h2] 
            ¬R → P → Q                    
────────────────────────────────── →i[h1] 
     (P ∧ ¬Q → R) → ¬R → P → Q            
```
<details>
  <summary>Proofweb</summary>

```
Require Import ProofWeb.

Parameter P Q R : Prop.

Theorem exercise_2_13 : ((P /\ ~Q) -> R) -> ~R -> P -> Q.
imp_i h1.
imp_i h2.
imp_i h3.
PBC h4.
neg_e R.
exact h2.
imp_e (P /\ ~Q).
exact h1.
con_i.
exact h3.
exact h4.

Proof.

Qed.
```
</details>
