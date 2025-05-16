## **Intent Integrity: Aligning Intent, Expertise, and AI**

By Baruch Sadogursky and Leonid Igolnik

---

### **Chapter 1 – From Panic to Pattern**

Every abstraction leap starts with existential fear and ends with progress.

We now witness a barrage of headlines predicting that AI will wipe out developer jobs. It’s not the first time we’ve heard this: the same panic accompanied the rise of high-level languages, managed runtimes, cloud platforms, and IaC tooling. Each wave brought new abstractions, fears, and, ultimately, more opportunity for those who adapted. The AI wave is just the latest, and if history tells us anything, the ones who adapt early aren’t just survivors, they’re the ones who shape what comes next.

We’ve seen this pattern before, and today we’re joined by two people who embody it: Leonid Igolnik, EVP of Engineering at Clari, veteran engineering manager, and Baruch Sadogursky, Head of Developer Relations at TuxCare, Java Champion and author of books about software delivery, sharing more than **50 years of experience** between them. They’ve seen abstraction waves come and go, and they’re here to show us how to turn fear into opportunity and guide us through the next one.

So, while the "we're all gonna lose our jobs" scare is probably just hype, the "AI generates garbage" scare is very much real. Even if we’re not afraid of being replaced, there’s still something developers don’t trust: the code AI writes.

That missing piece between what we wanted and what we asked for will appear again. Keep it in mind.

---

### **Chapter 2 – When Every Engineer Gets a Sidekick**

We’ve all heard the old thought experiment: give a million monkeys a million typewriters, and eventually they’ll write Shakespeare. Well, we gave them GPUs.

LLMs writing code aren’t evil or incompetent. They’re just fast guessers—glorified monkeys statistically nudged toward plausibility. Sure, they outperform randomness, but they’re still fundamentally non-deterministic. You can’t trust a monkey to write your production system—and yet, that’s what many teams are doing by default.

AI-generated code today is just barely this side of chaos. It might compile. It might even run. But that doesn’t mean it’s correct. And asking the same AI to fix its own mess? That’s like giving the monkeys spellcheck and hoping they discover iambic pentameter.

So yes, AI can generate garbage. But it’s not because it’s malicious or incompetent. It’s because that’s precisely what happens when you give a general-purpose tool to someone without deep domain expertise. The problem isn’t that the model is broken; it just doesn’t know what to do, and the operator can't help. And that’s not unique to software.

AI assistants have wormed their way into just about every profession. Paralegals draft first-cut briefs with legal copilots; radiologists triage scans with vision bots; sales reps lean on chat agents for discovery calls. Two patterns emerge:

1. The mass-market, one-click helpers aimed at dabblers churn out serviceable, but rarely production-ready, output.  
2. Domain-tuned agents placed in the hands of seasoned practitioners quietly rack up the wins: the lawyer who already knows case law spots the model’s missed precedent; the radiologist with thousands of reads catches the subtle false negative.

**Expertise comes first, amplification second, not the other way around.**

That same fork in the road now cuts straight through software engineering. For every “autocomplete-everything” gadget, there’s a specialist model designed to amplify existing know-how at a specific stage of the SDLC, development, testing, deployment, security, and operations.

Across all these categories, the pattern plays out consistently: AI sidekicks amplify mastery, but they don’t mint it. Expert hands erase drudgery and sharpen focus on architecture, edge cases, and creativity. Hand them to novices, and you will get cargo-cult commits, alert fatigue, or auto-merged security blunders.

This brings us to a subtle but profound point: experts get better results with AI not just because they know the domain; they can spot when something’s off. They don’t just use the tools; they validate the outcomes. They know what should have happened and see when the AI veers off course.

They know what should have happened and see when the AI veers off course.

And it takes that kind of expertise to distinguish Shakespeare from Shakespeare-adjacent. Just because the monkeys typed something that rhymes doesn’t mean it’s a sonnet. And just because the LLM produced something that compiles doesn’t mean it’s correct. The validation still falls on humans, for now.

That’s not about better prompting, it’s about knowing when your intent has been misunderstood. And that idea, of watching your intent slip through the cracks, is about to come up again.

---

### **Chapter 3 – Cautionary Tale: Unfenced AI**

Before we fire up a specialist copilot, we’ll take a short detour to show what happens when you drop a “just-make-it-work” prompt into a generic LLM and hit Enter.

Let’s say we have a public-facing API endpoint that processes a user-submitted JSON. We ask the AI to “make the endpoint faster.”

What it does is clever, but wrong: it removes or bypasses parts of the JSON validation logic, letting malformed inputs pass through. The endpoint responds faster, sure, but it breaks downstream systems because the behavior silently changes. There are no failing tests, no validation triggers, just a brittle implementation driven by an unbounded prompt.

And if you’re wondering, yes—it gets worse. When AI writes both the code *and* the tests, it’s like grading your own homework with invisible ink. And in our JSON validation example, this is exactly what could happen: even if the AI wrote tests initially, it might quietly remove them, say, the ones checking that input is properly verified. The test suite would pass, the endpoint would be faster, and no one would notice until something broke. That’s a problem we’ll have to solve.

This isn’t a story about malicious AI, it’s about something far more relatable: a developer who thought they asked one thing, but actually asked another, and got **precisely** what they asked for.

The author didn’t want the AI to remove validation. They wanted it to make the endpoint more performant. But the prompt never said that. The prompt left out what should never be changed.

And the AI, like a diligent intern with no context, followed instructions exactly. It did what it was told, not what was meant.

And here’s what’s humbling: this kind of mistake isn’t just something junior devs make. It happens to seasoned engineers, too. The more context you carry in your head, the harder it becomes to say it out loud. That’s the **curse of knowledge**: the better you understand something, the easier it is to assume others, or your AI assistant, do too.

That disconnect, the space between what you wanted and what you asked for, is going to matter a lot. It's the **intent-to-prompt chasm**, and once you see it, you can't unsee it. It's that moment when the AI outputs exactly what you typed, and you realize it’s not at all what you meant.

---

### **Chapter 4 – The Art of the Possible**

So, where do we go after the cautionary tale of an unfenced AI? We start thinking about how to make it work, safely. If a model will happily break our systems when given vague instructions, how do we steer it? With clear, intentional constraints.

What happened in that demo wasn’t just unfortunate, it was predictable. A missing test, an unbounded prompt, a lack of context. Every step that led to failure was a degree of freedom we could have constrained. So the question becomes: what does it take to know where and how to apply those constraints? That’s not a tooling problem, it’s a thinking problem. And it leads us to what we call the **Art of the Possible**: the practice of understanding what to constrain, and why.

That failure wasn’t caused by recklessness on the AI’s part, it was the result of vagueness on ours. No guardrails, no targets, no clear intent. That moment reflects something more profound: to guide AI well, you must know what to constrain and why. The people who do this well aren’t just good at prompt-writing; they understand the broader engineering and business context.

Seasoned software engineers possess something far richer than familiarity with a testing library. They carry deep expertise in software engineering itself, distilled from years of experience with systems at scale. They’ve seen where code breaks, understand why certain failures cascade disastrously, and can predict the ripple effects a seemingly trivial change might trigger.

This deep, intuitive understanding is the Art of the Possible. It rests on three essential dimensions:

#### **1\. Deep Domain Mastery**

Profound, practical knowledge about architecture, performance bottlenecks, security vulnerabilities, dependency pitfalls, and edge cases accumulated over thousands of builds, deployments, and outages.

#### **2\. Structured Imagination**

The creative yet disciplined skill of anticipating how things might go wrong, not only when working with AI, but especially valuable when working with AI. It’s what enables experienced engineers to foresee how an unbounded prompt could backfire, how a model might bypass a safety check, or how vague requirements can lead to unpredictable behavior.

#### **3\. Purposeful Guardrails**

Expertly crafted invariants expressed as rigorous tests, property-based checks, schema validations, contracts, or chaos simulations that clearly delineate safe boundaries for automation.

When these pillars combine, engineers shift from passively watching AI monkey agents run rampant to actively steering and guiding them with precision.

The Art of the Possible becomes a guiding principle, experts using their seasoned judgment to map precisely where automation can help, and placing guardrails to ensure AI respects domain constraints. It’s how we move fast without breaking alignment.

Let’s keep that in mind, because we’re about to put that precision to work.

And here’s the best part: mastery isn’t a gatekeeping badge, it’s a direction. Whether you’ve been writing code for 20 years or two months, what matters now is curiosity and intentionality. Start small. Explore a tool. Write a prompt. Wrap it in a guardrail. You don’t need to be an expert to practice the Art of the Possible; you need to start.

---

### **Chapter 5 – Small Pieces, Loosely Rebuildable**

AI is the best thing that’s happened to microservices since Martin Fowler and Chris Richardson.

In the age of LLMs, their greatest strength isn’t scalability, it’s **simplicity**. Small components are easier for humans to reason about. And that's not a throwaway point—it's foundational. Because remember: we give the system a prompt, and what we get back is a result. And it's on us, the human experts, to decide whether that result matches what we actually intended. If that result describes a massive, entangled subsystem, we're back to squinting at AI output and asking, 'Wait, is this what I meant?'

Smaller components make it easier to grasp what the AI did, easier to validate that it aligns with our expectations, and easier to make corrections. Oversight scales better when the thing you're overseeing is small.

But a tiny service with a clear boundary is not only easier for humans to prompt and validate. It’s also easier for the monkeys to generate. Give the monkeys something small and focused like FizzBuzz, and they’ll probably nail it on the first try. Ask for an ERP system and you’ll get endless and frustrating hallucinations and entropy.

And microservices have another unexpected benefit in the age of AI-generated (i.e. garbage) code. **They’re disposable.**

If your prompt was wrong, or your intent changed (we got a new feature requirement\!), or the monkey just got too clever, **you don't have to go through monkey-generated code and try to change or fix it**. You throw it out. You re-prompt, regenerate, replace. No tears. No archaeology. No tech debt.

This is how we manage the mess: **we throw it away.**

Microservices aren’t only about scale. In the context of AI-generated code, they’re about scope control, disposability, and making it easy to throw away garbage and keep moving fast.

---

### **Chapter 6 – Constraining Freedom: TDD Revisited**

So how do we make this sustainable at scale?

When the key to AI agents lies in strategically constraining their degrees of freedom, one proven method comes to mind: write tests first. A well-crafted test doesn’t just assert that your code works, it defines what “working” even means. By writing a test ahead of time, you draw a contract: hard boundaries around acceptable outcomes. You're creating a narrow corridor within which your AI copilot can safely maneuver.

This isn’t just good practice, it’s a pattern we’ve had for years: **Test-Driven Development** (TDD). TDD was built on a simple but powerful idea: write the test, see it fail, then implement just enough code to pass it. It constrained complexity and encouraged better software design.

Think back to the monkeys. You could have a million LLMs banging out implementations, but without clear constraints, you’re still stuck reviewing each one to figure out if any of it actually works. That’s not scalable.

But if you write the tests first—if you define, up front, what Shakespeare looks like—you don’t need to supervise every draft. The test becomes the judge. The experts only step in when the output actually passes. That’s how TDD, paired with AI, becomes not just a discipline, but a filter.

But let’s be honest, TDD failed to go mainstream. Developers are biased toward action. Once we understand the problem, our instinct is to jump into code, not pause to imagine failure scenarios. Writing tests first felt slow, even unnatural. And if no one demands it, why bother?

AI removes the friction that once made TDD feel burdensome. In the past, the rare developer who practiced TDD often did it out of discipline or guilt. Now every developer can do it without breaking flow. The assistant becomes scaffolding for discipline; you don’t have to enforce TDD; you just get it for free and on demand. It’s no longer a burden, it’s a practical advantage.

And in tools like Cursor, Windsurf, or Junie, you can encode those constraints directly. These systems can enforce test-first behavior through rules and guidelines file mechanisms: no implementation without verification criteria. It’s not perfect, but it’s a meaningful guardrail.

And now TDD  isn't just a "good practice" technique anymore; it's foundational. It’s the first link in the **Intent Integrity Chain**, a structured path ensuring your intent flows cleanly from idea to implementation, preserving alignment every step.

Tests aren’t just for correctness anymore. They’re where integrity starts. And they’re often the first place we catch the **intent-to-prompt chasm** before it grows into something harder to fix.

We’ll return to the full picture later, but for now, tests are its first, most practical link.

---

### **Chapter 7 – The BDD Eulogy**

Let’s return to the challenge we left off with in TDD: TDD aimed to be a contract: a **shared** understanding of how systems should behave. But contracts only work if everyone reviews and agrees on them. Developers did their part by writing tests that reflect their assumptions, but no one upstream reviewed them, and that's why TDD never made it. But it’s not because people don’t care; it’s because tests are written in code. Developers read code. Product managers and business stakeholders don’t. They don’t review tests because they’re uninterested, but because they’re locked out by format.

But what if they could? What if the expected behaviors, edge cases, and success criteria we write into tests could instead, or also, be described in plain English (or any other language)? This is the original insight behind **Behavior-Driven Development**.

If TDD is about writing tests to constrain code, BDD was a serious attempt to express code contracts (tests) through language. It offered a promise: describe expected behaviors in structured plain English and make that the **source of truth**. The core format, Given, When, Then, bridged the gap between developers and non-technical stakeholders, giving everyone a common reference point.

But the promise didn’t fully deliver. In practice, BDD requires strict structure, syntax, and discipline. While a step closer to the language of product managers, the rigid Gherkin format was still too much for them to use when writing product definitions. Developers ended up writing the specs themselves, and they asked (again) why bother. The overhead of formality outweighed the benefits. And without widespread tooling support or automation, BDD stalled.

It looks like the situation is even worse for the rigid Gherkin specs. Now that LLMs can turn free-form descriptions into working code, the rigid structure might seem completely and utterly obsolete. Looks like we don’t need specs at all.

So maybe it’s good riddance... but hang on.

---

### **Chapter 8 – Intent Integrity in Practice: Prompt, Spec, Test, Code**

Let’s not write off structure just yet.

Free-form prompts may be great for generating code, but are not great at validating intent. That’s where structure earns its keep. We need something in the middle: plain enough for humans, structured enough for machines.

And that’s where Gherkin comes back, not out of nostalgia, but utility.

So, where do specs fit? We aim for a system that translates human intent into verifiable execution. That’s the **Intent Integrity Chain**, a structured process for ensuring that our intent survives from idea to implementation.

Here’s how it works:

1. **Prompt**: You describe what you want. And here again, microservices help—not just for AI, but for us. Humans have context windows too. The smaller the problem, the easier it is to describe clearly, without missing details or assuming background knowledge. Smaller prompts mean tighter intent, fewer misunderstandings, and a better shot at getting what we actually meant.  
2. **Spec**: AI translates that into a structured, human-readable scenario, often in Gherkin.  
3. **Review**: A human checks that the spec matches the original intent. And this is where the microservice mindset pays off again: small components produce smaller specs—easier to grasp, faster to review, and more likely to actually get read instead of rubber-stamped. Let’s be honest—if it’s a wall of Gherkin, most folks are going to scroll, skim, and type 'LGTM' out of muscle memory. Simpler specs increase the odds that someone actually reads them with intent.  
4. **Test**: That scenario becomes an executable test.  
5. **Code**: AI writes code to pass the test.

Each step produces a verifiable artifact. Each step protects the one before it.

And here's why this matters: circular verification is one of the most concerning risks with AI-generated code. If the same LLM writes both the code and the tests, we can't trust either. But IIC gives us two strong guardrails.

First, while AI generates the implementation, the tests are generated by an algorithm, not monkey-coding magic. Once the specs are written in a machine-parsible way, parsing the specs to generate tests becomes a deterministic process. It’s the same mechanism BDD tools like Cucumber have followed for two decades. There’s no LLM monkey in that part of the chain.

Second, we lock the tests. According to the rules and guidelines (you remember those), once tests are generated from specs, the LLM is not allowed to modify them while working on the implementation. Today, the "rules and guidelines" are more guidelines than rules, but in theory it's technically enforceable. We can track Git history, detect unauthorized changes, and flag or block them. As tooling evolves, we’ll move from 'soft trust' to strict enforcement: locked files, write-protected steps, and traceable diffs.

That’s how we break the loop. Specs define behavior. Tests verify it. AI implements it. But **no part of the chain is allowed to validate itself**.

The magic is in having a spec that’s **human-readable and machine-verifiable**. That’s why Gherkin specs, for all their baggage, still work, and we’re finally using them right.

That’s the best of both worlds: **alignment without overhead**.

And of course, Gherkin isn’t a perfect tool—it’s a twenty-year-old relic from the early days of BDD, and its Cucumber roots are showing. But it’s what we have today: a usable, machine-parseable, semi-human-readable format that bridges free-form prompts and executable tests. If the IIC model gains traction, we’ll likely see this glue layer evolve. We’re not prescribing Gherkin as the final form—just acknowledging that it’s good enough, familiar, and here now.

At this point, it’s worth distinguishing between prompting and architecture. Prompting is transactional: you ask, it answers. The **Intent Integrity Chain** is architectural. It’s not about getting help from an LLM; it’s about structuring development around clearly expressed intent, verified step-by-step through specs, tests, and code. It’s a **system of alignment**, not just a shortcut.

Each layer builds on the one below it. That’s why we name each validation step:

* **Spec-to-Code validation**? That’s TDD.  
* **Behavior-to-Spec validation**? That’s BDD.  
* **Prompt-to-Spec validation**? That’s what we call **Prompt-Driven Development (PDD)**.

PDD is the starting point, but it’s only one link. Just as BDD depends on TDD to validate its structured scenarios through tests and implementation, PDD depends on the rest of the chain to verify the prompt’s meaning. The spec, the test, and the code complete the validation. The full chain ensures that every interpretation, every transformation, is checked.

Of course, that starting point, the prompt, is only as good as the intent it expresses. And that’s where the **Art of the Possible** comes in: domain mastery, structured imagination, and purposeful constraint. Writing a prompt that results in correct code isn’t just a matter of clarity; it’s a test of understanding. To guide an AI well, you must deeply understand your domain: its edge cases, constraints, and consequences. Vague prompts yield vague code. **Precise intent yields alignment**.

This opens up a new kind of collaboration. Engineers, product managers, and business stakeholders can now co-create prompts that describe real behavior, free-form, conversational, and grounded in shared understanding. But that’s just the start. The real alignment happens when those prompts are transformed by AI into structured, machine-verifiable specs. That’s where collaborative verification occurs, reviewing and refining those AI-generated specs until everyone agrees the output reflects the true intent, before a single line of implementation is written.

This **works in reverse**, too. With these tools, we can extract intent from existing systems, recovering the lost **why** behind legacy code. We can surface hidden assumptions, clarify forgotten constraints, and convert undocumented implementations into readable, reviewable artifacts, crafting a better path forward. Once the Intent Integrity Chain is (re)established, you can move faster and safer with the help of AI. Even in systems that started as monoliths, reverse IIC can expose natural boundaries and let you break them down into modular, composable parts. It’s not just a tool for understanding the past—it’s a gateway to rebuilding it better.

Microservices are a powerful ally here, too. If you're working with a system that's already modular, reverse IIC becomes far more manageable—you extract and validate intent one small, well-defined piece at a time. And even when dealing with a monolith, the process gives you a path forward: extract intent, identify boundaries, and begin carving it up into smaller components. Microservices help at both ends of the spectrum: as a convenient input, and as a clean target for reconstruction.

Regardless of the direction you apply it, the **Intent Integrity Chain** is how your ideas become software, with structure, validation, and trust.

And yes, you might run into a scenario where Gherkin doesn’t express your non-functional requirement clearly, or at all. That doesn’t mean the **Intent Integrity Chain** isn’t valid. It just means the glue layer—the format connecting intent to verification—still needs innovation. Gherkin is a starting point, not a ceiling.

And remember the monkeys? This is where they finally get their enclosure.

All those chaotic drafts, all the non-deterministic guesses—they're free to go wild *inside* a system that knows what to do with their output. The Intent Integrity Chain doesn’t stop the monkeys from typing. It just ensures they don’t get a standing ovation until a test—crafted from human-reviewed specs—declares: this one’s actually Shakespeare.

No more constant supervision. No more expert babysitting. Just a notification: the monkeys have done it. And this time, it’s real.

---

### **Chapter 9 – Bringing It All Home**

So, what do we walk away with?

This talk wasn’t just about AI. It wasn’t just about prompting. And it certainly wasn’t about Gherkin nostalgia.

It’s about the idea that we can preserve intent, cleanly, verifiably, from messy human goals to trustworthy running systems.

### **Closing – Three Things to Walk Away With**

1. **Every abstraction leap started with panic and ended with progress.** This is just the next one. Those who learn to adapt early shape what comes next, early in their career or decades in.  
2. **Mastery matters more than ever.** AI doesn’t eliminate the need for expertise; it makes it essential. For experienced engineers, this is your chance to evolve how you express and structure what you know. Even old farts like us still have to learn every day, and that’s what makes this field exciting. For those just starting out: build that mastery, piece by piece. Explore side projects. Contribute to open source. The tools are here; your growth doesn’t have to wait for permission.  
3. **Shared understanding is now executable.** With the **Intent Integrity Chain**, we can align teams around structured, testable intent before the first line of code is written, and trace it all the way to implementation, without falling into circular validation traps. Each step exists to protect the one before it. And remember \- whether you're building something new or decoding something old, IIC turns collaboration into working software—and it works best when you keep the pieces small enough for both humans and AIs to follow.

We started with a gap between what we meant and what we asked for, the **intent-to-prompt chasm**. The **Intent Integrity Chain** is how we close it step by step, artifact by artifact, until prompt and intent align.

If you remember nothing else, remember this: **You don’t need to speak AI. You need to speak clearly.**

The future of software belongs to those who understand their domain deeply, think in constraints, and collaborate in natural language.

In the end, it’s not just about prompting. It’s about **alignment**.

And if you’ve built the right system, even the monkeys can stay productive.

