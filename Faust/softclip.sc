FaustSoftclip : UGen
{
  *ar { | in1, amp_fuzz(0.0) |
      ^this.multiNew('audio', in1, amp_fuzz)
  }

  *kr { | in1, amp_fuzz(0.0) |
      ^this.multiNew('control', in1, amp_fuzz)
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

  name { ^"FaustSoftclip" }


  info { ^"Generated with Faust" }
}

