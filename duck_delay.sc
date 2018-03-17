FaustDuckDelay : UGen
{
  *ar { | in1, amount(0.5), attack(0.1), feedback(0.0), relese(0.1), time(500.0) |
      ^this.multiNew('audio', in1, amount, attack, feedback, relese, time)
  }

  *kr { | in1, amount(0.5), attack(0.1), feedback(0.0), relese(0.1), time(500.0) |
      ^this.multiNew('control', in1, amount, attack, feedback, relese, time)
  } 

  checkInputs {
    if (rate == 'audio', {
      1.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"FaustDuckDelay" }


  info { ^"Generated with Faust" }
}

