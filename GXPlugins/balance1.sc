FaustBalance1 : MultiOutUGen
{
  *ar { | in1, amp_balance(0.0) |
      ^this.multiNew('audio', in1, amp_balance)
  }

  *kr { | in1, amp_balance(0.0) |
      ^this.multiNew('control', in1, amp_balance)
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

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(2, rate)
  }

  name { ^"FaustBalance1" }


  info { ^"Generated with Faust" }
}

