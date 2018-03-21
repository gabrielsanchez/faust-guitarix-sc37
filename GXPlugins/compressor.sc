FaustCompressor : UGen
{
  *ar { | in1, attack(0.002), knee(3.0), ratio(2.0), release(0.5), threshold(-20.0) |
      ^this.multiNew('audio', in1, attack, knee, ratio, release, threshold)
  }

  *kr { | in1, attack(0.002), knee(3.0), ratio(2.0), release(0.5), threshold(-20.0) |
      ^this.multiNew('control', in1, attack, knee, ratio, release, threshold)
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

  name { ^"FaustCompressor" }


  info { ^"Generated with Faust" }
}

