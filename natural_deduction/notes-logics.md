Require Import ProofWeb.
```
Parameter P Q : D -> Prop.
Parameter t: D.

Theorem exercise_1 : P(t) -> all x, (P(x) -> ~Q(x)) -> ~Q(t).
Proof.
imp_i h1.
imp_i h2.
imp_e (P t).
all_e (all x, (P x -> ~Q x)).
exact h2.
exact h1.
Qed.
```
```
[∀x, (P x → ¬Q x)]h2                  
──────────────────── ∀e               
     P t → ¬Q t         [P t]h1       
─────────────────────────────── →e    
              ¬Q t                    
─────────────────────────────── →i[h2]
    ∀x, (P x → ¬Q x) → ¬Q t           
─────────────────────────────── →i[h1]
 P t → ∀x, (P x → ¬Q x) → ¬Q t        
```
```
​Require Import ProofWeb.

Parameter P Q R : D -> Prop.

Theorem exercise_1_2: all x, (Q x -> R x) -> exi x, (P x /\ Q x) -> exi x, (P x /\ R x).
Proof.
imp_i h1.
imp_i h2.
exi_e (exi x, (P x /\ Q x)) a h3.
exact h2.
exi_i a.
con_i.
con_e1 (Q a).
exact h3.
imp_e (Q a).
all_e (all x, (Q x -> R x)).
exact h1.
con_e2 (P a).
exact h3.
Qed.
```
```
                                      [∀x, (Q x → R x)]h1    [P a ∧ Q a]h3       
                                      ─────────────────── ∀e ───────────── ∧e₂   
                    [P a ∧ Q a]h3          Q a → R a              Q a            
                    ───────────── ∧e₁ ──────────────────────────────────── →e    
                         P a                           R a                       
                    ────────────────────────────────────────────────────── ∧i    
                                           P a ∧ R a                             
                    ────────────────────────────────────────────────────── ∃i    
[∃x, (P x ∧ Q x)]h2                     ∃x, (P x ∧ R x)                          
────────────────────────────────────────────────────────────────────────── ∃e[h3]
                              ∃x, (P x ∧ R x)                                    
────────────────────────────────────────────────────────────────────────── →i[h2]
                     ∃x, (P x ∧ Q x) → ∃x, (P x ∧ R x)                           
────────────────────────────────────────────────────────────────────────── →i[h1]
            ∀x, (Q x → R x) → ∃x, (P x ∧ Q x) → ∃x, (P x ∧ R x)                  
```
```
​Require Import ProofWeb.

Parameter A B P Q R : D -> Prop.

Theorem exercise_1_3: all x, (A x \/ B x) -> all x, (B x \/ A x).
Proof.
imp_i h1.
all_i t.
dis_e (A t \/ B t) h2 h3.
all_e (all x, (A x \/ B x)).
exact h1.
dis_i2.
exact h2.
dis_i1.
exact h3.
Qed.
```
```
[∀x, (A x ∨ B x)]h1     [A t]h2       [B t]h3           
─────────────────── ∀e ───────── ∨i₂ ───────── ∨i₁      
     A t ∨ B t         B t ∨ A t     B t ∨ A t          
────────────────────────────────────────────── ∨e[h2,h3]
                   B t ∨ A t                            
────────────────────────────────────────────── ∀i       
                ∀x, (B x ∨ A x)                         
────────────────────────────────────────────── →i[h1]   
       ∀x, (A x ∨ B x) → ∀x, (B x ∨ A x)
```
```
Require Import ProofWeb.

Parameter A B P Q R : D -> Prop.
Parameter t: D.

Theorem exercise_1_4: all x, (A x /\ B x) -> exi x, (B x).
Proof.
imp_i h1.
exi_i t.
con_e2 (A t).
all_e (all x, (A x /\ B x)).
exact h1.
Qed.
```
```
   [∀x, (A x ∧ B x)]h1          
   ─────────────────── ∀e       
        A t ∧ B t               
   ─────────────────── ∧e₂      
           B t                  
   ─────────────────── ∃i       
         ∃x, B x                
───────────────────────── →i[h1]
∀x, (A x ∧ B x) → ∃x, B x
```
```
​Require Import ProofWeb.

Parameter A B P Q R : D -> Prop.
Parameter t: D.

Theorem exercise_1_5: all x, (~A x) -> ~exi x, (A x).
Proof.
imp_i h1.
neg_i h2.
exi_e (exi x, A x) a h3.
exact h2.
neg_e (A a).
all_e (all x, ~A x).
exact h1.
exact h3.
Qed.
```
```
            [∀x, ¬A x]h1                  
            ──────────── ∀e               
                ¬A a        [A a]h3       
            ─────────────────────── ¬e    
[∃x, A x]h2           ⊥                 
─────────────────────────────────── ∃e[h3]
                ⊥                       
─────────────────────────────────── ¬i[h2]
              ¬∃x, A x                    
─────────────────────────────────── →i[h1]
        ∀x, ¬A x → ¬∃x, A x               
```
```
Require Import ProofWeb.

Parameter A B P Q R : D -> Prop.
Parameter t: D.

Theorem exercise_1_6: all x, (P x -> Q x) -> exi x, (P x) -> exi x, (Q x).
Proof.
imp_i h1.
imp_i h2.
exi_e (exi x, P x) a h3.
exact h2.
exi_i a.
imp_e (P a).
all_e (all x, (P x -> Q x)).
exact h1.
exact h3.
Qed.
```
```
            [∀x, (P x → Q x)]h1                  
            ─────────────────── ∀e               
                 P a → Q a         [P a]h3       
            ────────────────────────────── →e    
                          Q a                    
            ────────────────────────────── ∃i    
[∃x, P x]h2             ∃x, Q x                  
────────────────────────────────────────── ∃e[h3]
                  ∃x, Q x                        
────────────────────────────────────────── →i[h2]
             ∃x, P x → ∃x, Q x                   
────────────────────────────────────────── →i[h1]
    ∀x, (P x → Q x) → ∃x, P x → ∃x, Q x          
```
```
​Require Import ProofWeb.

Parameter A B P Q R : D -> Prop.
Parameter t: D.

Theorem exercise_2_1: (exi x, P x \/ exi x, Q x) -> exi x, (P x \/ Q x).
Proof.
imp_i h1.
dis_e (exi x, P x \/ exi x, Q x) h2 h3.
exact h1.
exi_e (exi x, P x) a h4.
exact h2.
exi_i a.
dis_i1.
exact h4.
exi_e (exi x, Q x) a h5.
exact h3.
exi_i a.
dis_i2.
exact h5.
Qed.
```
```
                                      [P a]h4                            [Q a]h5                                                
                                     ───────── ∨i₁                      ───────── ∨i₂                                           
                                     P a ∨ Q a                          P a ∨ Q a                                               
                                  ─────────────── ∃i                 ─────────────── ∃i                                         
                      [∃x, P x]h2 ∃x, (P x ∨ Q x)        [∃x, Q x]h3 ∃x, (P x ∨ Q x)                                            
                      ─────────────────────────── ∃e[h4] ─────────────────────────── ∃e[h5]                                     
[∃x, P x ∨ ∃x, Q x]h1       ∃x, (P x ∨ Q x)                    ∃x, (P x ∨ Q x)                                                  
──────────────────────────────────────────────────────────────────────────────────── ∨e[x),\/,_exi,(fun,x,=>,_K,(Q,x),x)),h2,h3]
                                   ∃x, (P x ∨ Q x)                                                                              
──────────────────────────────────────────────────────────────────────────────────── →i[h1]                                     
                         ∃x, P x ∨ ∃x, Q x → ∃x, (P x ∨ Q x)                                                                    
```
```
Require Import ProofWeb.

Parameter P : D -> D -> Prop.
Parameter t: D.

Theorem exercise_2_2: exi x, exi y, (P x y) -> exi y, exi x, (P x y).
Proof.
imp_i h1.
exi_e (exi x, exi y, P x y) a h2.
exact h1.
exi_e (exi y, P a y) b h3.
exact h2.
exi_i b.
exi_i a.
exact h3.
Qed.
```
```
                                  [P a b]h3         
                                  ───────── ∃i      
                                  ∃x, P x b         
                                ───────────── ∃i    
                  [∃y, P a y]h2 ∃y, ∃x, P x y       
                  ─────────────────────────── ∃e[h3]
[∃x, ∃y, P x y]h1        ∃y, ∃x, P x y              
───────────────────────────────────────────── ∃e[h2]
                ∃y, ∃x, P x y                       
───────────────────────────────────────────── →i[h1]
        ∃x, ∃y, P x y → ∃y, ∃x, P x y               
```
```
Require Import ProofWeb.

Parameter P Q : D -> Prop.
Parameter t: D.

Theorem exercise_2_3: exi x, (P x) -> all x, all y, (P x -> Q y) -> all y, (Q y).
Proof.
imp_i h1.
imp_i h2.
exi_e (exi x, P x) a h3.
exact h1.
all_i b.
imp_e (P a).
all_e (all y, (P a -> Q y)).
all_e (all x, all y, (P x -> Q y)).
exact h2.
exact h3.
Qed.
```
```
            [∀x, ∀y, (P x → Q y)]h2                  
            ─────────────────────── ∀e               
                ∀y, (P a → Q y)                      
            ─────────────────────── ∀e               
                   P a → Q b           [P a]h3       
            ────────────────────────────────── →e    
                            Q b                      
            ────────────────────────────────── ∀i    
[∃x, P x]h1               ∀y, Q y                    
────────────────────────────────────────────── ∃e[h3]
                    ∀y, Q y                          
────────────────────────────────────────────── →i[h2]
         ∀x, ∀y, (P x → Q y) → ∀y, Q y               
────────────────────────────────────────────── →i[h1]
    ∃x, P x → ∀x, ∀y, (P x → Q y) → ∀y, Q y          
```
```
​Require Import ProofWeb.

Parameter P Q : D -> Prop.
Parameter t: D.

Theorem exercise_2_4: exi x, (~P x) -> ~all x, P x.
Proof.
imp_i h1.
neg_i h2.
exi_e (exi x, ~P x) a h3.
exact h1.
neg_e (P a).
exact h3.
all_e (all x, P x).
exact h2.
Qed.
```
```
                      [∀x, P x]h2       
                      ─────────── ∀e    
             [¬P a]h3     P a           
             ──────────────────── ¬e    
[∃x, ¬P x]h1          ⊥               
───────────────────────────────── ∃e[h3]
               ⊥                      
───────────────────────────────── ¬i[h2]
             ¬∀x, P x                   
───────────────────────────────── →i[h1]
       ∃x, ¬P x → ¬∀x, P x              
```
```
​Require Import ProofWeb.

Parameter P Q : D -> Prop.
Parameter t: D.

Theorem exercise_2_5: ~all x, (P x) -> exi x, ~P x.
Proof.
imp_e (~exi x, ~P x -> ~~all x, P x).
imp_i h1.
imp_i h2.
negneg_e.
neg_i h3.
neg_e (~all x, P x).
imp_e (~exi x, ~P x).
exact h1.
exact h3.
exact h2.
imp_i h4.
negneg_i.
all_i a.
PBC h5.
neg_e (exi x, ~P x).
exact h4.
exi_i a.
exact h5.
Qed.
```
```
[¬∃x, ¬P x → ¬¬∀x, P x]h1 [¬∃x, ¬P x]h3                                      [¬P a]h5        
─────────────────────────────────────── →e                                   ──────── ∃i     
               ¬¬∀x, P x                   [¬∀x, P x]h2        [¬∃x, ¬P x]h4 ∃x, ¬P x        
─────────────────────────────────────────────────────── ¬e     ────────────────────── ¬e     
                          ⊥                                            ⊥                 
─────────────────────────────────────────────────────── ¬i[h3] ────────────────────── PBC[h5]
                       ¬¬∃x, ¬P x                                        P a                 
─────────────────────────────────────────────────────── ¬¬e    ────────────────────── ∀i     
                        ∃x, ¬P x                                       ∀x, P x               
─────────────────────────────────────────────────────── →i[h2] ────────────────────── ¬¬i    
                  ¬∀x, P x → ∃x, ¬P x                                 ¬¬∀x, P x              
─────────────────────────────────────────────────────── →i[h1] ────────────────────── →i[h4] 
     (¬∃x, ¬P x → ¬¬∀x, P x) → ¬∀x, P x → ∃x, ¬P x              ¬∃x, ¬P x → ¬¬∀x, P x        
───────────────────────────────────────────────────────────────────────────────────── →e     
                                 ¬∀x, P x → ∃x, ¬P x                                         
```
```
​Require Import ProofWeb.

Parameter P Q : D -> D -> Prop.
Parameter t: D.

Theorem exercise_3_1: exi x, all y, P x y -> all x, exi y, P y x.
Proof.
imp_i h1.
exi_e (exi x, all y, P x y) a h2.
exact h1.
all_i b.
exi_i a.
all_e (all y, P a y).
exact h2.
Qed.
```
```
                  [∀y, P a y]h2       
                  ───────────── ∀e    
                      P a b           
                  ───────────── ∃i    
                    ∃y, P y b         
                  ───────────── ∀i    
[∃x, ∀y, P x y]h1 ∀x, ∃y, P y x       
─────────────────────────────── ∃e[h2]
         ∀x, ∃y, P y x                
─────────────────────────────── →i[h1]
 ∃x, ∀y, P x y → ∀x, ∃y, P y x        
```
```
Require Import ProofWeb.

Parameter P Q : D -> Prop.
Parameter t: D.

Theorem exercise_3_2: exi x, ~P x -> ~all y, P y.
Proof.
imp_i h1.
neg_i h2.
exi_e (exi x, ~P x) a h3.
exact h1.
neg_e (P a).
exact h3.
all_e (all x , P x).
exact h2.
Qed.
```
```
                      [∀y, P y]h2       
                      ─────────── ∀e    
             [¬P a]h3     P a           
             ──────────────────── ¬e    
[∃x, ¬P x]h1          ⊥               
───────────────────────────────── ∃e[h3]
               ⊥                      
───────────────────────────────── ¬i[h2]
             ¬∀y, P y                   
───────────────────────────────── →i[h1]
       ∃x, ¬P x → ¬∀y, P y              
```
```
Require Import ProofWeb.

Parameter P Q : D -> Prop.
Parameter t: D.

Theorem exercise_3_3: ~exi x, P x -> all x, ~ P x.
Proof.
imp_i h1.
all_i a.
neg_i h2.
neg_e (exi x, P x).
exact h1.
exi_i a.
exact h2.
Qed.
```
```
             [P a]h2       
             ─────── ∃i    
[¬∃x, P x]h1 ∃x, P x       
──────────────────── ¬e    
         ⊥               
──────────────────── ¬i[h2]
        ¬P a               
──────────────────── ∀i    
      ∀x, ¬P x             
──────────────────── →i[h1]
 ¬∃x, P x → ∀x, ¬P x
```
```
​Require Import ProofWeb.

Parameter P Q : D -> Prop.
Parameter t: D.

Theorem exercise_3_4: all x, (P x /\ Q x) <-> (all x, P x /\ all x, Q x).
Proof.
iff_i h1 h2.
con_i.
all_i a.
con_e1 (Q a).
all_e (all x, (P x /\ Q x)).
exact h1.
all_i a.
con_e2 (P a).
all_e (all x, (P x /\ Q x)).
exact h1.
all_i a.
con_i.
all_e (all x, P x).
con_e1 (all x, Q x).
exact h2.
all_e (all x, Q x).
con_e2 (all x, P x).
exact h2.
Qed.
```
```
[∀x, (P x ∧ Q x)]h1     [∀x, (P x ∧ Q x)]h1     [∀x, P x ∧ ∀x, Q x]h2     [∀x, P x ∧ ∀x, Q x]h2           
─────────────────── ∀e  ─────────────────── ∀e  ───────────────────── ∧e₁ ───────────────────── ∧e₂       
     P a ∧ Q a               P a ∧ Q a                 ∀x, P x                   ∀x, Q x                  
─────────────────── ∧e₁ ─────────────────── ∧e₂ ───────────────────── ∀e  ───────────────────── ∀e        
        P a                     Q a                      P a                       Q a                    
─────────────────── ∀i  ─────────────────── ∀i  ─────────────────────────────────────────────── ∧i        
      ∀x, P x                 ∀x, Q x                              P a ∧ Q a                              
─────────────────────────────────────────── ∧i  ─────────────────────────────────────────────── ∀i        
             ∀x, P x ∧ ∀x, Q x                                  ∀x, (P x ∧ Q x)                           
─────────────────────────────────────────────────────────────────────────────────────────────── ifi[h1,h2]
                              ∀x, (P x ∧ Q x) ↔ ∀x, P x ∧ ∀x, Q x                                         
```
```
​Require Import ProofWeb.

Parameter P Q : D -> Prop.
Parameter t: D.

Theorem exercise_3_5: exi x, (P x \/ Q x) <-> (exi x, P x \/ exi x, Q x).
Proof.
iff_i h1 h2.
exi_e (exi x, (P x \/ Q x)) a h3.
exact h1.
dis_e (P a \/ Q a) h4 h5.
exact h3.
dis_i1.
exi_i a.
exact h4.
dis_i2.
exi_i a.
exact h5.
dis_e (exi x, P x \/ exi x, Q x) h6 h7.
exact h2.
exi_e (exi x, P x) a h8.
exact h6.
exi_i a.
dis_i1.
exact h8.
exi_e (exi x, Q x) a h9.
exact h7.
exi_i a.
dis_i2.
exact h9.
Qed.
```
```
                                       [P a]h4               [Q a]h5                                                      [P a]h8                            [Q a]h9                                                
                                       ─────── ∃i            ─────── ∃i                                                  ───────── ∨i₁                      ───────── ∨i₂                                           
                                       ∃x, P x               ∃x, Q x                                                     P a ∨ Q a                          P a ∨ Q a                                               
                                  ───────────────── ∨i₁ ───────────────── ∨i₂                                         ─────────────── ∃i                 ─────────────── ∃i                                         
                    [P a ∨ Q a]h3 ∃x, P x ∨ ∃x, Q x     ∃x, P x ∨ ∃x, Q x                                 [∃x, P x]h6 ∃x, (P x ∨ Q x)        [∃x, Q x]h7 ∃x, (P x ∨ Q x)                                            
                    ───────────────────────────────────────────────────── ∨e[h4,h5]                       ─────────────────────────── ∃e[h8] ─────────────────────────── ∃e[h9]                                     
[∃x, (P x ∨ Q x)]h1                   ∃x, P x ∨ ∃x, Q x                             [∃x, P x ∨ ∃x, Q x]h2       ∃x, (P x ∨ Q x)                    ∃x, (P x ∨ Q x)                                                  
───────────────────────────────────────────────────────────────────────── ∃e[h3]    ──────────────────────────────────────────────────────────────────────────────────── ∨e[x),\/,_exi,(fun,x,=>,_K,(Q,x),x)),h6,h7]
                            ∃x, P x ∨ ∃x, Q x                                                                          ∃x, (P x ∨ Q x)                                                                              
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────── ifi[h1,h2]                                 
                                                                   ∃x, (P x ∨ Q x) ↔ ∃x, P x ∨ ∃x, Q x
```